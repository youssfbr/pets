package com.github.youssfbr.pet.services.exceptions;

public class PetIsNullException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PetIsNullException() {
        super("Selecione um Pet.");
    }
}
