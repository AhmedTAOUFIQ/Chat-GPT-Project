package keiken.piscine.chatgpt.conversations.api.controller;


import keiken.piscine.chatgpt.conversations.api.entities.ChatConversation;
import keiken.piscine.chatgpt.conversations.api.repository.ChatConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetSessionsController {
    private final ChatConversationRepository chatConversationRepository;
    @Autowired
    public GetSessionsController(ChatConversationRepository chatConversationRepository) {
        this.chatConversationRepository = chatConversationRepository;
    }
    //Uploading the sessions to the front end
    @GetMapping(path="/conversations")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<ChatConversation> chatSessions() {

        return chatConversationRepository.findAll();
    }
}
