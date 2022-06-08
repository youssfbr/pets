package com.github.youssfbr.pet.api.dtos;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class PetRequestDTO {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 60)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 255)
    private String description;

    @URL
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String pic;

}
