package keiken.piscine.chatgpt.conversations.api.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data @Document
@NoArgsConstructor
public class ChatConversation {
    @Id
    private String conversationId;
    private String subject;
    private List<QuestionAnswerPair> questionAnswerPairs;

    public ChatConversation(String conversationId) {
        this.conversationId = conversationId;
        this.subject = "";
        this.questionAnswerPairs = new ArrayList<>();
    }

    public void addQuestionAnswerPair(String question, String answer) {
        this.questionAnswerPairs.add(new QuestionAnswerPair(question, answer,this.conversationId));
    }
}

