package com.alok.repoph.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class UtilityUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @NotNull(message = "password is mandatory.")
    private String password;

    private String address;


    private String mobileNumber;


    private String aadharNumber;

    @NotNull(message = "email is mandatory.")
    private String email;

    private Boolean hireStatus = false;

    private Date hireTime;

    private String role;

    @ElementCollection
    private List<String> occupations;

    @ManyToMany
    private List<UtilityUser> listOfHiredPeople;

}
