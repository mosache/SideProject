package com.vurtne.side.config;

import com.vurtne.side.util.OssUtil;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class OssConfig {

    @Resource
    private OssUtil ossUtil;

    @Bean
    public void getOssUtil() {
        boolean result = ossUtil.initOss();
        if (!result) {
            throw new RuntimeException("init oss failed!");
        }
    }
}
