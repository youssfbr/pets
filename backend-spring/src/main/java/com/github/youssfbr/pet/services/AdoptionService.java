package com.github.youssfbr.pet.services;

import com.github.youssfbr.pet.api.dtos.AdoptionRequestDTO;
import com.github.youssfbr.pet.api.dtos.AdoptionResponseDTO;
import com.github.youssfbr.pet.api.dtos.MessageResponseDTO;
import com.github.youssfbr.pet.api.mappers.AdoptionMapper;
import com.github.youssfbr.pet.entities.Adoption;
import com.github.youssfbr.pet.repositories.IAdoptionRepository;
import com.github.youssfbr.pet.services.exceptions.InternalServerError;
import com.github.youssfbr.pet.services.interfaces.IAdoptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AdoptionService implements IAdoptionService {

    private final IAdoptionRepository adoptionRepository;
    private final AdoptionMapper adoptionMapper;

    @Override
    @Transactional(readOnly = true)
    public List<AdoptionResponseDTO> findAll() {
        return adoptionRepository.findAll()
                .stream()
                .map(adoptionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MessageResponseDTO save(AdoptionRequestDTO adoptionRequestDTO) {
        try {
            Adoption adoptionToSave = adoptionMapper.toModel(adoptionRequestDTO);
            Adoption savedAdoption = adoptionRepository.save(adoptionToSave);

            return createMessageResponse("Adoção criada com ID ", savedAdoption.getId());
        }
        catch (Exception e) {
            throw new InternalServerError();
        }
    }

    private MessageResponseDTO createMessageResponse(final String message, final Long id) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

}
