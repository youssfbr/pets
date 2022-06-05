package com.github.youssfbr.pet.api.controllers.handler;

import com.github.youssfbr.pet.services.exceptions.InternalServerError;
import com.github.youssfbr.pet.services.exceptions.PetIsNullException;
import com.github.youssfbr.pet.services.exceptions.PetNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.Arrays;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(PetNotFoundException.class)
    public ResponseEntity<ApiErros> personNotFound(PetNotFoundException e) {

        ApiErros message = getError(HttpStatus.NOT_FOUND, e.getMessage());

        return ResponseEntity.status(message.getStatus()).body(message);
    }

    @ExceptionHandler(PetIsNullException.class)
    public ResponseEntity<ApiErros> personNotFound(PetIsNullException e) {

        ApiErros message = getError(HttpStatus.BAD_REQUEST, e.getMessage());

        return ResponseEntity.status(message.getStatus()).body(message);
    }

    @ExceptionHandler(InternalServerError.class)
    public ResponseEntity<ApiErros> cpfExists(InternalServerError e) {

        ApiErros message = getError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());

        return ResponseEntity.status(message.getStatus()).body(message);
    }

    private ApiErros getError(HttpStatus status, String message) {
        return ApiErros.builder()
                .dataHora(Instant.now())
                .status(status)
                .erros(Arrays.asList(message))
                .build();
    }


}
