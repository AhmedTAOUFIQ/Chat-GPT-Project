package keiken.piscine.chatgpt.propmts.api.services;


import keiken.piscine.chatgpt.propmts.api.DTO.GPTResponseDTO;
import keiken.piscine.chatgpt.propmts.api.entities.ChatConversation;
import keiken.piscine.chatgpt.propmts.api.services.OpenAiServiceInterface;
import keiken.piscine.chatgpt.propmts.api.services.RequestBuildingServiceInterface;
import keiken.piscine.chatgpt.propmts.api.services.SubjectServiceInterface;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SubjectService implements SubjectServiceInterface {
    private OpenAiServiceInterface openAiService;
    private RequestBuildingServiceInterface requestBuilder;

    @Autowired
    public SubjectService(OpenAiServiceInterface openAiService, RequestBuildingServiceInterface requestBuilder) {
        this.openAiService = openAiService;
        this.requestBuilder = requestBuilder;
    }

    public void updateConversationSubject(ChatConversation conversation) throws IOException, ParseException, InterruptedException {
        String generateSubject = "from all of this, generate a common subject , in not more than ten words, answer with the subject only";
        String prompt = requestBuilder.promptBuilder(conversation, generateSubject);
        GPTResponseDTO subject = openAiService.chatWithGpt(prompt);
        conversation.setSubject(subject.Answer().trim());
    }
}
