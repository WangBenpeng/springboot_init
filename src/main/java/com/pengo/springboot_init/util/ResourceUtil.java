package com.pengo.springboot_init.util;

import java.util.ResourceBundle;

/**
 * @author pengo
 * @description:
 * @date 2021/12/1 10:43 上午
 */
public class ResourceUtil {
    private static final String BASE_NAME = "messages";

    public static String get(String key) {
        return ResourceBundle.getBundle(BASE_NAME).getString(key);
    }
}
