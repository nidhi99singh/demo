package com.example.demo.response.Generics;

public interface ResponseDTO <T>{

    int getCode();

    void setCode(int code);

    String getMessage();

    ResponseDTO setMessage(String message);

    T getData();
    void setdata(T data);

    void setData(T data);
}
