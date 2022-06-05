package com.github.youssfbr.pet.api.controllers;

import com.github.youssfbr.pet.api.dtos.AdoptionRequestDTO;
import com.github.youssfbr.pet.services.interfaces.IAdoptionService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/adoptions")
@RequiredArgsConstructor
public class AdoptionController {

    private final IAdoptionService adoptionService;

    @PostMapping
    public void saveAdoption(@RequestBody AdoptionRequestDTO dto) {
        adoptionService.save(dto);
    }

}
