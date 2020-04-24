package com.alok.repoph.pojo;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Skill {

    private String skillName;

    private Integer experience;
}
