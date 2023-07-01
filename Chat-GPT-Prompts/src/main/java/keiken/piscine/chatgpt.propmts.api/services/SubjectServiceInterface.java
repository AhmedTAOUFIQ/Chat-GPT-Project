package keiken.piscine.chatgpt.propmts.api.services;

import keiken.piscine.chatgpt.propmts.api.entities.ChatConversation;
import org.apache.tomcat.util.json.ParseException;

import java.io.IOException;

public interface SubjectServiceInterface {
     void updateConversationSubject(ChatConversation session) throws IOException, ParseException, InterruptedException;
}
