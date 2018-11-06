package com.get.appbackend.domain.dto;

import com.get.appbackend.utils.ValidationGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter @NoArgsConstructor
public class SubjectRequestDto {

    @NotNull(groups = ValidationGroup.Update.class, message = "Subject Id can not be null")
    private Long id;

    @NotEmpty(groups = {ValidationGroup.Save.class, ValidationGroup.Update.class}, message = "Name can not be empty")
    @NotNull(groups = {ValidationGroup.Save.class, ValidationGroup.Update.class}, message = "Name can not be null")
    private String name;

    private String description;

}
