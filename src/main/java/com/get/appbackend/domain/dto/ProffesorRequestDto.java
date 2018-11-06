package com.get.appbackend.domain.dto;

import com.get.appbackend.utils.ValidationGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class ProffesorRequestDto {

    @NotNull(groups = ValidationGroup.Update.class, message = "Proffesor Id can not be null")
    private Long id;

    @NotEmpty(groups = {ValidationGroup.Save.class, ValidationGroup.Update.class}, message = "First name can not be empty")
    @NotNull(groups = {ValidationGroup.Save.class, ValidationGroup.Update.class}, message = "First name can not be null")
    private String firstName;

    @NotEmpty(groups = {ValidationGroup.Save.class, ValidationGroup.Update.class}, message = "Last name can not be empty")
    @NotNull(groups = {ValidationGroup.Save.class, ValidationGroup.Update.class}, message = "Last name can not be null")
    private String lastName;

    private List<Long> subjects;

}
