package com.mhys.cyxy.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseData<T> implements Serializable {
    private Integer code = 200;
    private String message;
    private T data;

    public ResponseData(){
        this.message = "success";
    }

    public ResponseData(T data){
        this.data = data;
        this.message = "success";
    }

    public static <T> ResponseData success(){
        ResponseData response = new ResponseData();
        response.setCode(200);
        response.setData(0);
        return response;
    }

    public static <T> ResponseData error(){
        ResponseData response = new ResponseData();
        response.setCode(500);
        response.message = "error";
        return response;
    }

    public static <T> ResponseData fail(){
        ResponseData response = new ResponseData();
        response.setCode(600);
        response.message = "fail";
        return response;
    }

    public static <T> ResponseData fail(String mesage){
        ResponseData response = new ResponseData();
        response.setCode(600);
        response.message = mesage;
        return response;
    }
}
