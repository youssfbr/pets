package com.github.youssfbr.pet.api.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.youssfbr.pet.api.controllers.validators.PetExistsById;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@JsonNaming(SnakeCaseStrategy.class)
public class AdoptionRequestDTO {

    @Email
    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @Min(10)
    @Max(100)
    private BigDecimal price;

    @NotNull
    @Positive
    @PetExistsById
    private Long petId;

}
