package com.alok.repoph.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Embeddable
@NoArgsConstructor
public class Contact {
    private String email;
    private String mobileNumber;
}
