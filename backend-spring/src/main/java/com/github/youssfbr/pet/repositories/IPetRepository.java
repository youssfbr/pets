package com.github.youssfbr.pet.repositories;

import com.github.youssfbr.pet.entities.Pet;
import com.github.youssfbr.pet.services.exceptions.PetNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPetRepository extends JpaRepository<Pet, Long> {

    default Pet findByIdOrElseThrow(Long petId) {
        return findById(petId)
                .orElseThrow(PetNotFoundException::new);
    }
}
