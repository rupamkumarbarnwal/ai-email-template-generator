package com.rupam.ai_email_generator.controller;

import com.rupam.ai_email_generator.dto.EmailRequest;
import com.rupam.ai_email_generator.dto.EmailResponse;
import com.rupam.ai_email_generator.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }


    @PostMapping("/generate")
    public EmailResponse generateEmail(@Valid @RequestBody EmailRequest emailRequest) {

        return emailService.generateEmail(emailRequest);
    }
}