package com.github.youssfbr.pet.services.interfaces;

import com.github.youssfbr.pet.api.dtos.PetResponseDTO;

import java.util.List;

public interface IPetService {

    List<PetResponseDTO> findAll();

}
