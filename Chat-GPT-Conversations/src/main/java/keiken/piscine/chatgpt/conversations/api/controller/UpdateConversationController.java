package keiken.piscine.chatgpt.conversations.api.controller;

import keiken.piscine.chatgpt.conversations.api.entities.ChatConversation;
import keiken.piscine.chatgpt.conversations.api.repositories.ChatConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateConversationController {
    private final ChatConversationRepository chatConversationRepository;
    @Autowired
    public UpdateConversationController(ChatConversationRepository chatConversationRepository) {
        this.chatConversationRepository = chatConversationRepository;
    }
    @PostMapping(path="/conversations/update")
    @CrossOrigin(origins = "http://ChatGPT-Project-Prompts")
    public ChatConversation updateChat(@RequestBody ChatConversation conversation) {
        System.out.println(conversation);
        ChatConversation updatedConversation =  chatConversationRepository.save(conversation);
        return updatedConversation;

    }
}
