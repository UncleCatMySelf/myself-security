package com.myself;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author  MySelf
 * @create  2018/9/15
 * @desc Demo SpringBoot 启动类
 **/
@SpringBootApplication
@RestController
@EnableSwagger2
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
public class DemoApplication {

    /**
     * 启动类
     * @param args {@link String}
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }

    /**
     * 初始化创建接口服务
     * @return {@link String}
     */
    @GetMapping("/hello")
    public String hello(){
        return "Hello Spring Security";
    }

}
