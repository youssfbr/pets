package com.github.youssfbr.pet.api.mappers;

import com.github.youssfbr.pet.api.dtos.AdoptionRequestDTO;
import com.github.youssfbr.pet.api.dtos.AdoptionResponseDTO;
import com.github.youssfbr.pet.entities.Adoption;
import com.github.youssfbr.pet.repositories.IPetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdoptionMapper {

    private final IPetRepository petRepository;
    private final PetMapper petMapper;

    public Adoption toModel(AdoptionRequestDTO dto) {
        return Adoption.builder()
                .email(dto.getEmail())
                .price(dto.getPrice())
                .pet(petRepository
                        .findByIdOrElseThrow(dto.getPetId()))
                .build();
    }

    public AdoptionResponseDTO toDTO(Adoption adoption) {
        return AdoptionResponseDTO.builder()
                .id(adoption.getId())
                .email(adoption.getEmail())
                .price(adoption.getPrice())
                .pet(petMapper.toResponseDTO(adoption.getPet()))
                .build();
    }

}
