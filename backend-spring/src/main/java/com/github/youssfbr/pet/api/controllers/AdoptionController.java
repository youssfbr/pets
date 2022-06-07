package com.github.youssfbr.pet.api.controllers;

import com.github.youssfbr.pet.api.dtos.AdoptionRequestDTO;
import com.github.youssfbr.pet.api.dtos.MessageResponseDTO;
import com.github.youssfbr.pet.services.interfaces.IAdoptionService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/adoptions")
@RequiredArgsConstructor
public class AdoptionController {

    private final IAdoptionService adoptionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createAdoption(@RequestBody @Valid AdoptionRequestDTO adoptionRequestDTO) {
         return adoptionService.save(adoptionRequestDTO);
    }

}
