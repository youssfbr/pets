package com.github.youssfbr.pet.services.exceptions;

import lombok.Getter;

@Getter
public class InternalServerError extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InternalServerError() {
        super("Erro interno. Por favor entrar em contato com o suporte.");

    }
}
