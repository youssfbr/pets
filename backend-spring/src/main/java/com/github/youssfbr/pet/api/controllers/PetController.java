package com.github.youssfbr.pet.api.controllers;

import com.github.youssfbr.pet.api.dtos.PetResponseDTO;
import com.github.youssfbr.pet.services.interfaces.IPetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pets")
@RequiredArgsConstructor
public class PetController {

    private final IPetService petService;

    @GetMapping
    public List<PetResponseDTO> findAll() {
        return petService.findAll();
    }

}
