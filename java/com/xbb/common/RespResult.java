package com.xbb.common;

public class RespResult {

    private Integer code = 0;
    private String message;
    private long count;
    private Object data;

    public void error(String message) {
        this.code = -1;
        this.message = message;
    }

    public void success(Object data) {
        this.data = data;
    }

    public void success(Object data, long count) {
        this.count = count;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
