package com.pengo.springboot_init;

import com.pengo.springboot_init.service.LogService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootInitApplicationTests {

    @Resource
    private LogService logService;

    @Test
    void contextLoads() {
        logService.log();
    }

}
