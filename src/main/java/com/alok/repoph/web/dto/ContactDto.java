package com.alok.repoph.web.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class ContactDto {
    @NonNull
    private String email;
    @NonNull
    private String mobileNumber;
}
