package org.stylizedsubstance.mybank.web;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.stylizedsubstance.mybank.dto.ErrorDto;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // Handles method argument validation errors that are annotated with @Valid
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ErrorDto handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        Integer statusCode = exception.getBody().getStatus();
        List<ErrorDto.ErrorField> errorFields = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> new ErrorDto.ErrorField(fieldError.getField(), fieldError.getDefaultMessage()))
                .toList();

        return new ErrorDto(statusCode, errorFields);
    }

    // Handles request parameter errors
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorResponse handleConstraintViolation(ConstraintViolationException exception) {
        return new ErrorResponse(400, exception.getMessage());
    }
}
