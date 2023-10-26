package com.david.spring_angular.handlers;

import com.david.spring_angular.exceptions.ObjectNonPermittedException;
import com.david.spring_angular.exceptions.ObjectValidationException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectValidationException.class)
    public ResponseEntity<ExceptionRepresentation> handleException(ObjectValidationException exception) {
        ExceptionRepresentation representation = ExceptionRepresentation.builder()
                .errorMessage("Object not valid exception has occurred")
                .errorSource(exception.getViolationSource())
                .validationsErrors(exception.getViolations())
                .build();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(representation);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionRepresentation> handleException(EntityNotFoundException exception) {
        ExceptionRepresentation representation = ExceptionRepresentation.builder()
                .errorMessage(exception.getMessage())
                .build();
        return ResponseEntity.
                status(HttpStatus.NOT_FOUND)
                .body(representation);
    }

    @ExceptionHandler(ObjectNonPermittedException.class)
    public ResponseEntity<ExceptionRepresentation> handleException(ObjectNonPermittedException exception) {
        ExceptionRepresentation representation = ExceptionRepresentation.builder()
                .errorMessage(exception.getMessage())
                .build();
        return ResponseEntity.
                status(HttpStatus.NOT_ACCEPTABLE)
                .body(representation);
    }

}