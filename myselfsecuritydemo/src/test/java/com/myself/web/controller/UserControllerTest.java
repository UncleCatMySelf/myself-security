package com.myself.web.controller;

import com.myself.DemoApplicationTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author  MySelf
 * @create  2018/9/15
 * @desc User Controller 测试类
 **/
public class UserControllerTest extends DemoApplicationTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    /**
     * 配置环境上下文
     */
    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    /**
     * 测试获取用户列表接口 成功时
     * @throws Exception
     */
    @Test
    public void whenQuerySuccess() throws Exception{
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .param("username","jack")
                .param("age","18")
                .param("ageTo","24")
                .param("xxx","yyy")
                .param("size","15")
                .param("page","3")
                .param("sort","age,desc")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);

    }

    /**
     * 测试获取用户信息 成功时
     * @throws Exception
     */
    @Test
    public void whenGenInfoSuccess() throws Exception{
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("tom"))
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }

    /**
     * 测试获取用户信息 失败时
     * @throws Exception
     */
    @Test
    public void whenGenInfoFail() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/user/a")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());

    }


}
