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
    private String source;

    public Result() {
    }

    ;

    public Result(ResultCode resultCode, Object data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public Result(ResultCode resultCode, String source, Object data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.source = source;
        this.data = data;
    }
}
