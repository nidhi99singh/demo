package com.example.demo.enums;

import com.example.demo.response.Generics.ResponseCode;

public enum ApiResponseCode implements ResponseCode {
    SUCCESS(0, "SUCCESS"),
    ERROR(1, "ERROR"),
    AUTH_FAILED(4, "AUTH_FAILED");

    private int code;
    private String message;

    ApiResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
