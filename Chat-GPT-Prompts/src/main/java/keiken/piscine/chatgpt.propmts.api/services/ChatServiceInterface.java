package keiken.piscine.chatgpt.propmts.api.services;

import keiken.piscine.chatgpt.propmts.api.entities.ChatConversation;
import org.apache.tomcat.util.json.ParseException;

import java.io.IOException;

public interface ChatServiceInterface {
    ChatConversation getAnswerFromGPT (String sessionID, String question) throws IOException, ParseException, InterruptedException;
}
