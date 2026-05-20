package com.rupam.ai_email_generator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class OpenAIConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }
}
