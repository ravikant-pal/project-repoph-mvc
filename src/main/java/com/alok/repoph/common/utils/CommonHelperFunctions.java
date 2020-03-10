package com.alok.repoph.common.utils;

import com.alok.repoph.pojo.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CommonHelperFunctions {

    public static final ResponseEntity<Object> buildResponseEntity(ApiResponse apiResponse) {
        return new ResponseEntity<>(apiResponse, HttpStatus.valueOf(apiResponse.getStatus()));
    }

    public static final ResponseEntity<Object> buildResponseEntity(ApiResponse apiResponse, HttpStatus httpStatus) {
        return new ResponseEntity<>(apiResponse, httpStatus);
    }
}
