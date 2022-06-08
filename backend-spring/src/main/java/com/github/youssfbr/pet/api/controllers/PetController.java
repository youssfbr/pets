package com.github.youssfbr.pet.api.controllers;

import com.github.youssfbr.pet.api.dtos.MessageResponseDTO;
import com.github.youssfbr.pet.api.dtos.PetRequestDTO;
import com.github.youssfbr.pet.api.dtos.PetResponseDTO;
import com.github.youssfbr.pet.services.interfaces.IPetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pets")
public class PetController {

    private final IPetService petService;

    @GetMapping
    public List<PetResponseDTO> findAll() {
        return petService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPet(@RequestBody @Valid PetRequestDTO petRequestDTO) {
        return petService.createPet(petRequestDTO);
    }

}
