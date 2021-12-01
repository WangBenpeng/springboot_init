package com.pengo.springboot_init.error;

/**
 * @author pengo
 * @description:
 * @date 2021/12/1 11:09 上午
 */
public class MyException extends RuntimeException {
    private String code;
    private String msg;

    public MyException() {
        super();
    }

    public MyException(String code) {
        this.code = code;
    }

    public MyException(String code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    public MyException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.msg = message;
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
}
