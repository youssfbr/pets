package com.github.youssfbr.pet.api.controllers.handler;

import com.github.youssfbr.pet.services.exceptions.InternalServerError;
import com.github.youssfbr.pet.services.exceptions.PetIsNullException;
import com.github.youssfbr.pet.services.exceptions.PetNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request
    ) {
        var body = ErrorResponse.builder()
                .statusCode(status.value())
                .status(status.getReasonPhrase())
                .cause(exception.getClass().getSimpleName())
                .message("Houveram erros de validação")
                .timestamp(LocalDateTime.now())
                .errors(convertFieldErros(exception.getBindingResult().getFieldErrors()))
                .build();

        return new ResponseEntity<>(body, status);
    }

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

    private Map<String, List<String>> convertFieldErros(List<FieldError> fieldErrors) {
        var errors = new HashMap<String, List<String>>();
        fieldErrors.stream().forEach(fieldError -> {
            var field = fieldError.getField();
            if (errors.containsKey(field)) {
                errors.get(field).add(fieldError.getDefaultMessage());
            } else {
                var errorList = new ArrayList<String>();
                errorList.add(fieldError.getDefaultMessage());
                errors.put(field, errorList);
            }
        });
        return errors;
    }


}
