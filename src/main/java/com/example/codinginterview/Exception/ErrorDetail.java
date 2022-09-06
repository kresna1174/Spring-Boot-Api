package com.example.codinginterview.Exception;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorDetail {

    private HttpStatus status;
    private String message;

    public ErrorDetail(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = status.toString().replace('_', ' ');
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
