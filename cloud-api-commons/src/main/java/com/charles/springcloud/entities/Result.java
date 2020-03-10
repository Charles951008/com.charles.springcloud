package com.charles.springcloud.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Charles
 */
@Data
public class Result implements Serializable {
    private Integer code;
    private String message;
    private Object data;

    public Result(){ };
    public Result(ResultCode resultCode, Object data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }
}
