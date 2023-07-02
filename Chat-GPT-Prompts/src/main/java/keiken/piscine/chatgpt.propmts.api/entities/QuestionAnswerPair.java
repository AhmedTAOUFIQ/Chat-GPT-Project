package keiken.piscine.chatgpt.propmts.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class QuestionAnswerPair {
    @Id
    private Long id;
    private String question;
    private String answer;
    private String conversationId;


}


