package com.github.youssfbr.pet.api.controllers.handler;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.github.youssfbr.pet.services.exceptions.InternalServerError;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    private final SnakeCaseStrategy snakeCaseStrategy = new SnakeCaseStrategy();

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
            var field = snakeCaseStrategy.translate(fieldError.getField());
            if (errors.containsKey(field)) {
                errors.get(field).add(fieldError.getDefaultMessage());
            } else {
                errors.put(
                        field,
                        Stream.of(fieldError.getDefaultMessage()).collect(Collectors.toList())
                );
            }
        });
        return errors;
    }


}
