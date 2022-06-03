package com.github.youssfbr.pet.repositories;

import com.github.youssfbr.pet.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPetRepository extends JpaRepository<Pet, Long> {
}
