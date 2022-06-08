package com.github.youssfbr.pet.services.interfaces;

import com.github.youssfbr.pet.api.dtos.AdoptionRequestDTO;
import com.github.youssfbr.pet.api.dtos.AdoptionResponseDTO;
import com.github.youssfbr.pet.api.dtos.MessageResponseDTO;

import java.util.List;

public interface IAdoptionService {

    List<AdoptionResponseDTO> findAll();
    MessageResponseDTO save(AdoptionRequestDTO adoptionRequestDTO);

}
