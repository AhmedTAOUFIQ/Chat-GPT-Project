package keiken.piscine.chatgpt.conversations.api.entities;

import jakarta.persistence.*;
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
    private List<QuestionAnswerPair> questionAnswerPairs = new ArrayList<>();

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

