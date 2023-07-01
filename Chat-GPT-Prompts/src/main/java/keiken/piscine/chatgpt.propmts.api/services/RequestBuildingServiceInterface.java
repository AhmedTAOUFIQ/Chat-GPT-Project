package keiken.piscine.chatgpt.propmts.api.services;

import keiken.piscine.chatgpt.propmts.api.entities.ChatConversation;

public interface RequestBuildingServiceInterface {
    String promptBuilder(ChatConversation session, String question);
}
