package com.xueqi.Intelligent_office.dto;

public class JsonMessage {

    private int code;
    private String message;

    public JsonMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public JsonMessage() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
