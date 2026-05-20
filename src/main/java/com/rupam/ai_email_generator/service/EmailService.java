package com.rupam.ai_email_generator.service;

import com.rupam.ai_email_generator.dto.EmailRequest;
import com.rupam.ai_email_generator.dto.EmailResponse;

public interface EmailService {

    EmailResponse generateEmail(EmailRequest emailRequest);

}
