package com.lg.warehouse.dto;

import org.springframework.lang.Nullable;

/**
 * @author lin
 * @ClassName ResponseDTO
 * @date 2018/9/39 15:56
 * @description
 **/
public class ResponseDTO<T> {
    private int status;
    private String msg;
    private T data;

    public ResponseDTO(int status, String msg, @Nullable T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setmsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getmsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
