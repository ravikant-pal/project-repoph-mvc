package com.alok.repoph.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Embeddable
@NoArgsConstructor
public class Rating {
    private Double rat =0.0;
    private Integer noOfPeopleGives = 0;
}
