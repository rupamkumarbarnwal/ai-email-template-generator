# AI Email Template Generator

## Project Overview

AI Email Template Generator is a Spring Boot based REST API application that generates professional email templates dynamically using OpenAI API integration. The application accepts user inputs such as purpose, recipient name, and tone, and generates AI-powered email responses.

This project demonstrates:
- REST API development
- Layered architecture
- OpenAI API integration
- Validation and exception handling
- Secure environment variable handling
- WebClient usage in Spring Boot

---

## Features

- Generate AI-powered email templates
- RESTful API implementation
- Layered architecture design
- Request validation using Jakarta Validation
- Global exception handling
- Custom exception handling
- OpenAI API integration using WebClient
- Environment variable based API key configuration
- Response time calculation
- Professional project structure

---

## Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Spring WebFlux
- WebClient
- Maven
- OpenAI API
- Postman
- Git & GitHub

---

## Project Structure

```text
src/main/java/com/rupam/ai_email_generator

├── controller
│   └── EmailController.java
│
├── service
│   └── EmailService.java
│
├── serviceimpl
│   └── EmailServiceImpl.java
│
├── dto
│   ├── EmailRequest.java
│   └── EmailResponse.java
│
├── exception
│   ├── AIServiceException.java
│   ├── GlobalException.java
│   └── ResourceNotValidException.java
│
├── config
│   └── OpenAIConfig.java
│
└── AiEmailGeneratorApplication.java
API Endpoint
Generate Email
POST /api/email/generate
Request Body
{
  "purpose": "Leave Request",
  "recipientName": "Anitha",
  "tone": "Professional"
}
Sample Response

Sample AI-generated email response depends on active OpenAI API quota and billing availability.

Validation

The application uses validation annotations such as:

@NotBlank
@Valid

Validation ensures that required fields are not empty before processing the request.

Exception Handling

Global exception handling is implemented using:

@RestControllerAdvice
Custom exceptions
Validation exception handling
Custom Exceptions
AIServiceException
ResourceNotValidException
Environment Variable Configuration

API keys are secured using environment variables.

application.properties
openai.api.key=${OPENAI_API_KEY}
openai.api.url=https://api.openai.com/v1/chat/completions
IntelliJ Environment Variable
OPENAI_API_KEY=your_api_key
How to Run the Project
Clone Repository
git clone https://github.com/rupamkumarbarnwal/ai-email-template-generator.git
Navigate to Project
cd ai-email-template-generator
Configure Environment Variable

Add your OpenAI API key in IntelliJ Run Configuration.

Run Application
mvn spring-boot:run
Test API Using Postman
POST http://localhost:8084/api/email/generate
Response Time Calculation

The application calculates total API response generation time using:

System.currentTimeMillis()
Future Improvements
Frontend integration
Multiple email template support
Database integration
User authentication
Email history tracking
Async email generation
Docker deployment
Author

Rupam Kumar Barnwal
