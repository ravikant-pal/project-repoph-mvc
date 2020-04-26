package com.alok.repoph.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@Embeddable
@AllArgsConstructor
public class About {
    @NonNull
    private String title;
    @NonNull
    private String description;
}
