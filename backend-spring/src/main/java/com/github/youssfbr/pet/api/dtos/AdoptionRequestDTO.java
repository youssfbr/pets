package com.github.youssfbr.pet.api.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AdoptionRequestDTO {

    private String email;
    private BigDecimal price;
    private Long petId;

}
