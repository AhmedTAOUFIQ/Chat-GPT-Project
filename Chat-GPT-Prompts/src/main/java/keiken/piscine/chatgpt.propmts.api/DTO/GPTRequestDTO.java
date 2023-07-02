package keiken.piscine.chatgpt.propmts.api.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GPTRequestDTO {
    private String model;
    private String prompt;
    private double temperature;
    private int max_tokens;

    public GPTRequestDTO(String prompt) {
        this.prompt = prompt;
        this.model = "text-davinci-003";
        this.temperature = 0.8;
        this.max_tokens = 100;
    }
}
