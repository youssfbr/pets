package com.github.youssfbr.pet.services.interfaces;

import com.github.youssfbr.pet.api.dtos.MessageResponseDTO;
import com.github.youssfbr.pet.api.dtos.PetRequestDTO;
import com.github.youssfbr.pet.api.dtos.PetResponseDTO;

import java.util.List;

public interface IPetService {

    List<PetResponseDTO> findAll();
    MessageResponseDTO createPet(PetRequestDTO petRequestDTO);

}
