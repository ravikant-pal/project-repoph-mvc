package com.alok.repoph.pojo;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Occupation {

    private String occupationsName;

    private Integer experienceInYears;
}
