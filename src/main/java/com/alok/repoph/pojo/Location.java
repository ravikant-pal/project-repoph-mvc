package com.alok.repoph.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Embeddable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @NonNull
    private Double latitude;
    @NonNull
    private Double longitude;
}
