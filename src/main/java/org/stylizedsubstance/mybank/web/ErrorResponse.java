package org.stylizedsubstance.mybank.web;

public class ErrorResponse {
    private Integer statusCode;
    private String message;

    public ErrorResponse(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public Integer getStatus() {
        return statusCode;
    }

    public void setStatus(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
