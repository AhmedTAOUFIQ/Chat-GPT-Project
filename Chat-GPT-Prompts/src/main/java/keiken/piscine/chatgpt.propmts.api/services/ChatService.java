package keiken.piscine.chatgpt.propmts.api.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import keiken.piscine.chatgpt.propmts.api.DTO.GPTResponseDTO;
import keiken.piscine.chatgpt.propmts.api.entities.ChatConversation;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

@Service
public class ChatService implements ChatServiceInterface {

    private RequestBuildingServiceInterface requestBuilder;
    private OpenAiServiceInterface openAiService;
    private SubjectServiceInterface subjectService;
    private final WebClient.Builder webClientBuilder;

    @Autowired
    public ChatService(RequestBuildingServiceInterface requestBuilder, OpenAiServiceInterface openAiService, SubjectServiceInterface subjectService, WebClient.Builder webClientBuilder) {
        this.requestBuilder = requestBuilder;
        this.openAiService = openAiService;
        this.subjectService = subjectService;
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public ChatConversation getAnswerFromGPT(String conversationId, String question) throws IOException, ParseException, InterruptedException {

        String response = webClientBuilder.build().get().uri("http://ChatGPT-Project-Conversations/conversations/" + conversationId).retrieve().bodyToMono(String.class).block();
        ObjectMapper objectMapper = new ObjectMapper();
        ChatConversation conversation = objectMapper.readValue(response,ChatConversation.class);

        // Adding the new question and answer
        String request = requestBuilder.promptBuilder(conversation, question);
        GPTResponseDTO GPTResponseDTO = openAiService.chatWithGpt(request);
        conversation.addQuestionAnswerPair(question, GPTResponseDTO.Answer().trim());
        subjectService.updateConversationSubject(conversation);

        // Call update conversation from the conversation API
        ChatConversation upDatedConversation= webClientBuilder.build().post()
                .uri("http://ChatGPT-Project-Conversations/conversations/update")
                .bodyValue(conversation)
                .retrieve()
                .bodyToMono(ChatConversation.class)
                .block();

        return conversation;
    }

}
