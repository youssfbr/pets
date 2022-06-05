package com.github.youssfbr.pet.services;

import com.github.youssfbr.pet.api.dtos.AdoptionRequestDTO;
import com.github.youssfbr.pet.api.mappers.AdoptionMapper;
import com.github.youssfbr.pet.entities.Adoption;
import com.github.youssfbr.pet.repositories.IAdoptionRepository;
import com.github.youssfbr.pet.services.exceptions.InternalServerError;
import com.github.youssfbr.pet.services.exceptions.PetIsNullException;
import com.github.youssfbr.pet.services.exceptions.PetNotFoundException;
import com.github.youssfbr.pet.services.interfaces.IAdoptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AdoptionService implements IAdoptionService {

    private final IAdoptionRepository adoptionRepository;
    private final AdoptionMapper adoptionMapper;

    @Override
    public void save(AdoptionRequestDTO dto) {
        try {
            if (dto.getPetId() == null) throw new PetIsNullException();

            Adoption adoptionToSave = adoptionMapper.toModel(dto);
            Adoption adoptionSaved = adoptionRepository.save(adoptionToSave);
        }
        catch (PetNotFoundException e) {
            throw e;
        }
        catch (Exception e) {
            throw new InternalServerError();
        }
    }

}
