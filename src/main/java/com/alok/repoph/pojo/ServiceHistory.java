package com.alok.repoph.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalTime;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ServiceHistory {
    private String opponent;
    private String email;
    private LocalTime hireStartTime;
    private LocalTime hireEndTime;
    private String status;

    public ServiceHistory(String opponent, String email, LocalTime hireStartTime, String status) {
        this.opponent = opponent;
        this.email = email;
        this.hireStartTime = hireStartTime;
        this.status = status;
    }

    public ServiceHistory(String opponent, String email, String status) {
        this.opponent = opponent;
        this.email = email;
        this.status = status;
    }
}
