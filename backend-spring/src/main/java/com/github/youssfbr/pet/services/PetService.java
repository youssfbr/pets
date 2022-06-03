package com.github.youssfbr.pet.services;

import com.github.youssfbr.pet.entities.Pet;
import com.github.youssfbr.pet.repositories.IPetRepository;
import com.github.youssfbr.pet.services.interfaces.IPetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService implements IPetService {

    private final IPetRepository petRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Pet> findAll() {
        return petRepository.findAll();
    }
}
