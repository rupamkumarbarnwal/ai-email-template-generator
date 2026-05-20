package com.rupam.ai_email_generator.dto;


import jakarta.validation.constraints.NotBlank;

public class EmailRequest {
    @NotBlank(message = "Purpose cannot be blank")
    private String purpose;
    @NotBlank(message = "Recipient name cannot be blank")
    private String recipientName;
    @NotBlank(message = "Tone cannot be blank")
    private String tone;

    public EmailRequest() {
    }

    public EmailRequest(String purpose, String recipientName, String tone) {
        this.purpose = purpose;
        this.recipientName = recipientName;
        this.tone = tone;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getTone() {
        return tone;
    }

    public void setTone(String tone) {
        this.tone = tone;
    }

    @Override
    public String toString() {
        return "EmailRequest{" +
                "purpose='" + purpose + '\'' +
                ", recipientName='" + recipientName + '\'' +
                ", tone='" + tone + '\'' +
                '}';
    }
}
