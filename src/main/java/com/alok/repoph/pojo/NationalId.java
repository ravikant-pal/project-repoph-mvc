package com.alok.repoph.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Embeddable;

@Data
@Embeddable
@NoArgsConstructor
public class NationalId {
    @NonNull
    private String type;
    @NonNull
    private String number;
}
