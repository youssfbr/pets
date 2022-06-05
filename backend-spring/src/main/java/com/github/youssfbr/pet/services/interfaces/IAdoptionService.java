package com.github.youssfbr.pet.services.interfaces;

import com.github.youssfbr.pet.api.dtos.AdoptionRequestDTO;
import com.github.youssfbr.pet.api.dtos.MessageResponseDTO;

public interface IAdoptionService {

    MessageResponseDTO save(AdoptionRequestDTO dto);

}
