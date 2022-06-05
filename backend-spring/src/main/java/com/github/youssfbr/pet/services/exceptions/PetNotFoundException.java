package com.github.youssfbr.pet.services.exceptions;

public class PetNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PetNotFoundException(Long id) {
        super("Pet não encontrado com ID: " + id);
    }
}
