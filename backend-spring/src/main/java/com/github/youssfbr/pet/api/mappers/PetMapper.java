package com.github.youssfbr.pet.api.mappers;

import com.github.youssfbr.pet.api.dtos.PetRequestDTO;
import com.github.youssfbr.pet.api.dtos.PetResponseDTO;
import com.github.youssfbr.pet.entities.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {

    public PetResponseDTO toResponseDTO(Pet pet) {
        return PetResponseDTO.builder()
                .id(pet.getId())
                .name(pet.getName())
                .description(pet.getDescription())
                .pic(pet.getPic())
                .build();
    }

    public Pet toModel(PetRequestDTO petRequestDTO) {
        return Pet.builder()
                .name(petRequestDTO.getName())
                .description(petRequestDTO.getDescription())
                .pic(petRequestDTO.getPic())
                .build();
    }

}
