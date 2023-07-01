package keiken.piscine.chatgpt.propmts.api.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import keiken.piscine.chatgpt.propmts.api.DTO.GPTResponseDTO;
import org.apache.tomcat.util.json.ParseException;

import java.io.IOException;
import java.net.http.HttpRequest;

public interface OpenAiServiceInterface {
    GPTResponseDTO chatWithGpt(String message) throws IOException, InterruptedException, ParseException;

    HttpRequest.BodyPublisher chatMessageAsPostBody(String message) throws JsonProcessingException;

    String completionBuilder(String message) throws JsonProcessingException;
}
