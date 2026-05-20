package com.rupam.ai_email_generator.dto;



public class EmailResponse {

    private String email;
    private long responseTime;

    public EmailResponse() {
    }

    public EmailResponse(String email, long responseTime) {
        this.email = email;
        this.responseTime = responseTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    @Override
    public String toString() {
        return "EmailResponse{" +
                "email='" + email + '\'' +
                ", responseTime=" + responseTime +
                '}';
    }
}
