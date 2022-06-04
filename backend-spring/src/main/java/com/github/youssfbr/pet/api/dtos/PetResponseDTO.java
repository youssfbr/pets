package com.github.youssfbr.pet.api.dtos;

import lombok.Data;

@Data
public class PetResponseDTO {

    private Long id;
    private String name;
    private String description;
    private String pic;

}
