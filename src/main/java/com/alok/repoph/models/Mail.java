package com.alok.repoph.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;
@Data
@NoArgsConstructor
@ToString
public class Mail {
    private String from;
    private String to;
    private String subject;
    private Map<String, Object> model;

}
