package com.github.youssfbr.pet.api.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
@JsonNaming(SnakeCaseStrategy.class)
public class AdoptionResponseDTO {

    private Long id;
    private String email;
    private BigDecimal price;
    private PetResponseDTO pet;

}
