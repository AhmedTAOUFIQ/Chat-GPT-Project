package keiken.piscine.chatgpt.conversations.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @AllArgsConstructor @NoArgsConstructor
@Document
public class QuestionAnswerPair {
    private String question;
    private String answer;
    private String conversationId;


}


