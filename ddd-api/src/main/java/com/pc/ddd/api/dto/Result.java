package com.pc.ddd.api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private T model;
    private String message;
    private String code;
    private boolean success = true;


    public static <T> Result<T> of(T data) {
        Result<T> response = new Result<>();
        response.setSuccess(true);
        response.setModel(data);
        return response;
    }

}
