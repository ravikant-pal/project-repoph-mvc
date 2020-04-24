package com.alok.repoph.pojo;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

@Data
@Embeddable
public class Address {
    @NotEmpty
    private String houseNumber;
    @NotEmpty
    private String street;
    @NotEmpty
    private String city;
    @NotEmpty
    private String pinCode;
    @NotEmpty
    private String country;
}
