package com.br.movies.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {

    private final String message;
    private final String details;
    private final LocalDateTime timestamp;

    public ErrorResponse(String message, String details) {
        this.message = message;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }

}
