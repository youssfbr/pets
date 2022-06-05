package com.github.youssfbr.pet.api.mappers;

import com.github.youssfbr.pet.api.dtos.AdoptionRequestDTO;
import com.github.youssfbr.pet.entities.Adoption;
import com.github.youssfbr.pet.repositories.IPetRepository;
import com.github.youssfbr.pet.services.exceptions.PetNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdoptionMapper {

    private final IPetRepository petRepository;

    public Adoption toModel(AdoptionRequestDTO dto) {

        Adoption adoption = new Adoption();
        adoption.setEmail(dto.getEmail());
        adoption.setPrice(dto.getPrice());
        adoption.setPet(petRepository
                .findById(dto.getPetId())
                .orElseThrow(() -> new PetNotFoundException(dto.getPetId()))
        );

        return adoption;
    }

}
