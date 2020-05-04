package com.alok.repoph.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalTime;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class HireHistory {
    private String opponent;
    private String title;
    private String email;
    private Double price;
    private LocalTime hireStartTime;
    private LocalTime hireEndTime;
    private String status;

    public HireHistory(String opponent, String title, String email, Double price, LocalTime hireStartTime, String status) {
        this.opponent = opponent;
        this.title = title;
        this.email = email;
        this.price = price;
        this.hireStartTime = hireStartTime;
        this.status = status;
    }

    public HireHistory(String opponent, String title, String email, Double price, String status) {
        this.opponent = opponent;
        this.title = title;
        this.email = email;
        this.price = price;
        this.status = status;
    }
}
