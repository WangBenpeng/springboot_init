package com.pengo.springboot_init.result;

import com.pengo.springboot_init.error.ErrorCode;
import com.pengo.springboot_init.util.ResourceUtil;

/**
 * @author pengo
 * @description:
 * @date 2021/12/1 10:29 上午
 */
public class Result<T> {
    private String code;
    private String msg;
    private T data;

    private Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result success() {
        return success(ErrorCode.OK, ResourceUtil.get(ErrorCode.OK), null);
    }

    public static Result success(String msg) {
        return success(msg, null);
    }

    public static <T> Result<T> success(T data) {
        return success(ResourceUtil.get(ErrorCode.OK), data);
    }

    public static <T> Result<T> success(String msg, T data) {
        return success(ErrorCode.OK, msg, data);
    }

    public static <T> Result<T> success(String code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

    public static <T> Result<T> error() {
        return error(ErrorCode.ERROR, ResourceUtil.get(ErrorCode.ERROR), null);
    }

    public static <T> Result<T> error(String msg) {
        return error(ErrorCode.ERROR, msg);
    }

    public static <T> Result<T> error(String code, String msg) {
        return error(code, msg, null);
    }

    public static <T> Result<T> error(String code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
