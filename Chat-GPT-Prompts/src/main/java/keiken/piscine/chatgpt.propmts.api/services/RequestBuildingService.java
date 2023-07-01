package keiken.piscine.chatgpt.propmts.api.services;

import keiken.piscine.chatgpt.propmts.api.entities.ChatConversation;
import org.springframework.stereotype.Service;

@Service
public class RequestBuildingService implements RequestBuildingServiceInterface {
    public String promptBuilder(ChatConversation conversation, String question) {
        StringBuilder builder = new StringBuilder();
        if (conversation.getQuestionAnswerPairs().size() != 0) {
            if (conversation.getQuestionAnswerPairs().size() < 20) {
                for (int i = 0; i < conversation.getQuestionAnswerPairs().size(); i++) {
                    builder.append(conversation.getQuestionAnswerPairs().get(i).getQuestion() + " \n ");
                    builder.append(conversation.getQuestionAnswerPairs().get(i).getAnswer() + " \n ");
                }
                builder.append(question);

            } else {
                for (int i = conversation.getQuestionAnswerPairs().size() - 20; i < conversation.getQuestionAnswerPairs().size(); i++) {
                    builder.append(conversation.getQuestionAnswerPairs().get(i).getQuestion() + " \n ");
                    builder.append(conversation.getQuestionAnswerPairs().get(i).getAnswer() + " \n ");
                }
                builder.append(question);
            }
        } else {
            builder.append(question);
        }
        return builder.toString();
    }
}
