package org.stylizedsubstance.mybank.dto;

import java.util.ArrayList;
import java.util.List;

public class ErrorDto {
    private Integer statusCode;
    private List<ErrorField> errorFields;

    public ErrorDto() {
        this.errorFields = new ArrayList<>();
    }

    public ErrorDto(Integer statusCode, List<ErrorField> errorFields) {
        this.statusCode = statusCode;
        this.errorFields = errorFields;
    }

    public List<ErrorField> getErrorFields() {
        return errorFields;
    }

    public void setErrorFields(List<ErrorField> errorFields) {
        this.errorFields = errorFields;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public static class ErrorField {
        private String name;
        private String message;

        public ErrorField(String name, String message) {
            this.name = name;
            this.message = message;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
