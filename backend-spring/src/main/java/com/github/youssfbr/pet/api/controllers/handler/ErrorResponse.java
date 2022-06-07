package com.github.youssfbr.pet.api.controllers.handler;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class ErrorResponse {

    private LocalDateTime timestamp;
    private int statusCode;
    private String status;
    private String cause;
    private String message;
    private Map<String, List<String>> errors;

}
