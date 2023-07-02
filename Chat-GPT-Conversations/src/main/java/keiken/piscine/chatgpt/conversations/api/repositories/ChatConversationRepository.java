package keiken.piscine.chatgpt.conversations.api.repositories;

import keiken.piscine.chatgpt.conversations.api.entities.ChatConversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatConversationRepository extends JpaRepository<ChatConversation, String> {
    ChatConversation getChatConversationByConversationId(String conversationId);
}
