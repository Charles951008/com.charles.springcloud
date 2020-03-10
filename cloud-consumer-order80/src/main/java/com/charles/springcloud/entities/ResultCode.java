package com.charles.springcloud.entities;

import lombok.Getter;


/**
 * @author Charles
 */

@Getter
public enum ResultCode {
    /**
     * 1111
     *
     * @param
     * @param code
     * @param message
     * @param
     */

    /* 成功状态码 */
    SUCCESS(200, "成功"),

    /* 失败状态码 */
    PARAM_IS_INVALID(1001, "参数无效"),
    INSERT_IS_FAILED(1002,"插入数据库失败");

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;

    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }


}
