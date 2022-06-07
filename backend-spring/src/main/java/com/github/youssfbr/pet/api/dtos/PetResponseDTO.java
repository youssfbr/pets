package com.github.youssfbr.pet.api.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PetResponseDTO {

    private Long id;
    private String name;
    private String description;
    private String pic;

}
