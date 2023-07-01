package keiken.piscine.chatgpt.conversations.api.repository;

import keiken.piscine.chatgpt.conversations.api.entities.ChatConversation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatConversationRepository extends MongoRepository<ChatConversation, String> {
    ChatConversation getChatConversationByConversationId(String conversationId);

}
