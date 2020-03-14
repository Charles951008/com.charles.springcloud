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

    /**
     * @description 带有eureka标识的状态码
     * @param resultCode 状态码
     * @param source eureka标识
     * @param data 返回的结果集
     */
    public Result(ResultCode resultCode, String source, Object data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.source = source;
        this.data = data;
    }
}
