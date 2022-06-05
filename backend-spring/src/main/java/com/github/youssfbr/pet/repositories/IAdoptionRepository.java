package com.github.youssfbr.pet.repositories;

import com.github.youssfbr.pet.entities.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdoptionRepository extends JpaRepository<Adoption, Long> {
}
