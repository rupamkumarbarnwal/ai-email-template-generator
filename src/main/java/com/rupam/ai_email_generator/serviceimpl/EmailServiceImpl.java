package com.rupam.ai_email_generator.serviceimpl;

import com.rupam.ai_email_generator.dto.EmailRequest;
import com.rupam.ai_email_generator.dto.EmailResponse;
import com.rupam.ai_email_generator.exception.AiServiceException;

import com.rupam.ai_email_generator.service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;
import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${openai.api.url}")
    private String apiUrl;

    private final WebClient webClient;

    public EmailServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public EmailResponse generateEmail(EmailRequest emailRequest) {

        long startTime = System.currentTimeMillis();

        String prompt =
                "Generate a " + emailRequest.getTone() +
                        " email for " + emailRequest.getRecipientName() +
                        " regarding " + emailRequest.getPurpose();

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-3.5-turbo",
                "messages", List.of(
                        Map.of(
                                "role", "user",
                                "content", prompt
                        )
                )
        );

        Map response;

        try {

            response = webClient.post()
                    .uri(apiUrl)
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();

        } catch (WebClientResponseException ex) {

            throw new AiServiceException(
                    "AI service error: " + ex.getStatusCode()
            );
        }

        List choices = (List) response.get("choices");

        Map choice = (Map) choices.get(0);

        Map message = (Map) choice.get("message");

        String generatedEmail = (String) message.get("content");

        long endTime = System.currentTimeMillis();

        long responseTime = endTime - startTime;

        return new EmailResponse(generatedEmail, responseTime);
    }
}