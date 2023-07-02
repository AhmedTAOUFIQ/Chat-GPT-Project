package keiken.piscine.chatgpt.propmts.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

@Entity
public class ChatConversation {
    @Id
    private String conversationId;
    private String subject;
    @OneToMany
    private List<QuestionAnswerPair> questionAnswerPairs;

    public ChatConversation(String conversationId) {
        this.conversationId = conversationId;
        this.subject = "";
        this.questionAnswerPairs = new ArrayList<>();
    }

    public void addQuestionAnswerPair(String question, String answer) {
        this.questionAnswerPairs.add(
                QuestionAnswerPair.builder()
                        .question(question)
                        .answer(answer)
                        .conversationId(conversationId)
                        .build()
        );
    }
}

