package com.get.appbackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlingController {

    private static final String VALIDATION_ERROR_MSG = "Validation Error!";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> invalidRequestBody(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> errors = result.getFieldErrors();
        List<String> errorStringForm = new ArrayList<>();
        for (FieldError error : errors) {
            errorStringForm.add(error.getDefaultMessage());
        }
        ExceptionResponse response = new ExceptionResponse(HttpStatus.BAD_REQUEST, new Date(), VALIDATION_ERROR_MSG, errorStringForm);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
