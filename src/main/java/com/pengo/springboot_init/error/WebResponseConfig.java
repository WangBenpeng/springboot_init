package com.pengo.springboot_init.error;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author benpeng
 * @date 2022/9/8 15:58
 */
@Configuration
public class WebResponseConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.removeIf(e -> e.getClass().isAssignableFrom(StringHttpMessageConverter.class));
    }
}

