package com.pengo.springboot_init.error;

import com.pengo.springboot_init.result.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ResourceBundle;

/**
 * @author pengo
 * @description:
 * @date 2021/12/1 11:12 上午
 */
@RestControllerAdvice("com.pengo")
public class MyExceptionHandler implements ResponseBodyAdvice<Object> {

    @ExceptionHandler(MyException.class)
    public Result handleMyException(HttpServletRequest req, HttpServletResponse resp, MyException e) {
        String msg = ResourceBundle.getBundle("messages", req.getLocale()).getString(e.getCode());
        return Result.error(e.getCode(), msg);
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        return Result.error(e.getMessage());
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Result beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof Result)
            return (Result) body;
        return Result.success(ResourceBundle.getBundle("messages", ((ServletServerHttpRequest) request).getServletRequest().getLocale()).getString(ErrorCode.OK), body);
    }
}
