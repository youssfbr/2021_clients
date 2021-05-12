package com.github.youssfbr.clients.rest.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrors> handleValidationErrors(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<String> messages = bindingResult.getAllErrors()
                .stream()
                .map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList());
        return ResponseEntity.badRequest().body(new ApiErrors(messages));
    }
}
