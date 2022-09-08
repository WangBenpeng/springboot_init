package com.pengo.springboot_init.controller;

import com.pengo.springboot_init.error.ErrorCode;
import com.pengo.springboot_init.error.MyException;
import com.pengo.springboot_init.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pengo
 * @description:
 * @date 2021/12/1 11:03 上午
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @PostMapping("/say")
    public Result<String> say() {
        return Result.success("操作成功！", "Hello, I'm Springboot!");
    }

    @PostMapping("/user")
    public User user() {
        User user = new User("user", 18);
        return user;
    }

    @PostMapping("/exception")
    public Object exception() {
        throw new RuntimeException("this is global exception");
    }

    @PostMapping("/myexception")
    public Object myException() {
        throw new MyException(ErrorCode.ERROR);
    }

    @PostMapping("/string")
    public String string() {
        return "Hello,I'm String.";
    }
}

class User{
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
