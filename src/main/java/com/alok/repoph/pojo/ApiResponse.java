package com.alok.repoph.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiResponse {

    private int status;
    private String message;
    private Object data;

    public ApiResponse() {
        super();
    }

    public ApiResponse(HttpStatus status, String message, Object data) {
        super();
        this.status = status.value();
        this.message = message;
        this.data = data;
    }

    public ApiResponse(Integer status, String message, Object data) {
        super();
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(HttpStatus status, String message) {
        super();
        this.status = status.value();
        this.message = message;

    }
}
