package com.pengo.springboot_init.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Benpeng
 * @since 2023/7/3 15:01
 */
@Slf4j
@Service
public class LogService {

    public void log(){
        log.debug("this is debug message");
        log.info("this is info message");
        log.warn("this is warn message");
        log.error("this is error message");
    }
}
