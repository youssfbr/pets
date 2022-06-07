package com.github.youssfbr.pet.api.mappers;

import com.github.youssfbr.pet.api.dtos.AdoptionRequestDTO;
import com.github.youssfbr.pet.entities.Adoption;
import com.github.youssfbr.pet.repositories.IPetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdoptionMapper {

    private final IPetRepository petRepository;

    public Adoption toModel(AdoptionRequestDTO dto) {

        return Adoption.builder()
                .email(dto.getEmail())
                .price(dto.getPrice())
                .pet(petRepository
                        .findByIdOrElseThrow(dto.getPetId()))
                .build();
    }

}
