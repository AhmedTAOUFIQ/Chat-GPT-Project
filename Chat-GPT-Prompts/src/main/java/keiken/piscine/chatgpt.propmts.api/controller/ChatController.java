package keiken.piscine.chatgpt.propmts.api.controller;



import keiken.piscine.chatgpt.propmts.api.entities.ChatConversation;
import keiken.piscine.chatgpt.propmts.api.services.ChatServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatController {
    private final ChatServiceInterface chatService;
    @Autowired
    public ChatController(ChatServiceInterface chatService) {
        this.chatService = chatService;
    }
    // Getting the question from the Front-End, asking GPT for the answer and updating the session and the subject
    @PostMapping(path = "/prompts/{conversationId}/qa")
    @CrossOrigin(origins = "http://localhost:3000")
    public ChatConversation chat(@PathVariable String conversationId, @RequestBody String question) throws Exception {
       return chatService.getAnswerFromGPT(conversationId,question);
    }


}
