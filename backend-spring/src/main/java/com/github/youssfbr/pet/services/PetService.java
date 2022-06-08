package com.github.youssfbr.pet.services;

import com.github.youssfbr.pet.api.dtos.MessageResponseDTO;
import com.github.youssfbr.pet.api.dtos.PetRequestDTO;
import com.github.youssfbr.pet.api.dtos.PetResponseDTO;
import com.github.youssfbr.pet.api.mappers.PetMapper;
import com.github.youssfbr.pet.entities.Pet;
import com.github.youssfbr.pet.repositories.IPetRepository;
import com.github.youssfbr.pet.services.exceptions.InternalServerError;
import com.github.youssfbr.pet.services.interfaces.IPetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetService implements IPetService {

    private final IPetRepository petRepository;
    private final PetMapper petMapper;

    @Override
    @Transactional(readOnly = true)
    public List<PetResponseDTO> findAll() {

        return petRepository.findAll()
                .stream()
                .map(petMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MessageResponseDTO createPet(PetRequestDTO petRequestDTO) {
        try {
            Pet petToCreate = petMapper.toModel(petRequestDTO);
            Pet createdPet = petRepository.save(petToCreate);

            return createMessageResponse("Pet salvo com ID ", createdPet.getId());
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
