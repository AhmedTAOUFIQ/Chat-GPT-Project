package keiken.piscine.chatgpt.propmts.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor @AllArgsConstructor
public class QuestionAnswerPair {
    private String question;
    private String answer;
    private String conversationId;


}


