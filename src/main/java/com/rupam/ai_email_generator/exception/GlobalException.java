package com.rupam.ai_email_generator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(ResourceNotValidException.class)
    public ResponseEntity<String> handleResourceNotValidException(ResourceNotValidException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AiServiceException.class)
    public ResponseEntity<String> handleAiServiceException(
            AiServiceException ex){

        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.SERVICE_UNAVAILABLE
        );
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
