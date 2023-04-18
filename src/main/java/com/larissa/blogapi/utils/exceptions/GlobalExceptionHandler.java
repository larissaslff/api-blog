package com.larissa.blogapi.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErroMessage> resourceNotFoundException(ResourceNotFound ex){
        ErroMessage erroMessage = ErroMessage.builder()
                .message(ex.getMessage())
                .code(HttpStatus.NOT_FOUND.value())
                .time(LocalDate.now())
                .build();
        return new ResponseEntity<>(erroMessage, HttpStatus.NOT_FOUND);
    }
}
