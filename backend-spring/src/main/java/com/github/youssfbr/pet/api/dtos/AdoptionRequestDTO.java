package com.github.youssfbr.pet.api.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonNaming(SnakeCaseStrategy.class)
public class AdoptionRequestDTO {

    private String email;
    private BigDecimal price;
    private Long petId;

}
