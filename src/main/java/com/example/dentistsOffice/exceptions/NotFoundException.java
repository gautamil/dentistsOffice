package com.example.dentistsOffice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotFoundException {

    @ExceptionHandler({ExceptionMessage.class})
    public ResponseEntity processingNotFound(ExceptionMessage exm){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exm.getMessage());
    }

}
