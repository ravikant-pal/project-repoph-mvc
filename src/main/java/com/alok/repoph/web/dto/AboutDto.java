package com.alok.repoph.web.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class AboutDto {
    @NonNull
    private String title;
    @NonNull
    private String description;
}
