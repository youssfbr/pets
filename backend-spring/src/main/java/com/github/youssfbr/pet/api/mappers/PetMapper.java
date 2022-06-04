package com.github.youssfbr.pet.api.mappers;

import com.github.youssfbr.pet.api.dtos.PetResponseDTO;
import com.github.youssfbr.pet.entities.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {

    public PetResponseDTO toDTO(Pet pet) {
        PetResponseDTO petResponseDTO = new PetResponseDTO();
        petResponseDTO.setId(pet.getId());
        petResponseDTO.setName(pet.getName());
        petResponseDTO.setDescription(pet.getDescription());
        petResponseDTO.setPic(pet.getPic());
        return petResponseDTO;
    }

}
