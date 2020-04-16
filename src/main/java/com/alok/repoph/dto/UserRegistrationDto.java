package com.alok.repoph.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserRegistrationDto {
    @NotEmpty
    private String fullName;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

}
