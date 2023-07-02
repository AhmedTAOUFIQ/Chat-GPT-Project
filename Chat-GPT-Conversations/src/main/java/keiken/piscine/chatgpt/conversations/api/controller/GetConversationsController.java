package keiken.piscine.chatgpt.conversations.api.controller;


import keiken.piscine.chatgpt.conversations.api.entities.ChatConversation;
import keiken.piscine.chatgpt.conversations.api.repositories.ChatConversationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class GetConversationsController {
    private final ChatConversationRepository chatConversationRepository;

    @Autowired
    public GetConversationsController(ChatConversationRepository chatConversationRepository) {
        this.chatConversationRepository = chatConversationRepository;
    }

    //Getting session's conversation when user clicks on the chatSession
    @GetMapping("/conversations/{conversationId}")
    @CrossOrigin(origins = "http://ChatGPT-Project-Prompts")
    public ChatConversation createConversation(@PathVariable String conversationId) {
        if (conversationId.equalsIgnoreCase("new")) {
            conversationId = UUID.randomUUID().toString();
            ChatConversation newConversation = new ChatConversation(conversationId);
            chatConversationRepository.save(newConversation);
            return newConversation;
        } else {
            return chatConversationRepository.getChatConversationByConversationId(conversationId);
        }
    }
}