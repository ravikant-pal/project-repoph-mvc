package com.alok.repoph.web.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserRegistrationDto {
    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    private Boolean gender;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    private Boolean role;
}
