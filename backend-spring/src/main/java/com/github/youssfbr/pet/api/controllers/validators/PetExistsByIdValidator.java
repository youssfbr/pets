package com.github.youssfbr.pet.api.controllers.validators;

import com.github.youssfbr.pet.repositories.IPetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class PetExistsByIdValidator implements ConstraintValidator<PetExistsById, Long> {

    private final IPetRepository petRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return petRepository.existsById(value);
    }
}
