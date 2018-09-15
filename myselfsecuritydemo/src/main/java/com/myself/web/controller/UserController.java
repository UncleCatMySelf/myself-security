package com.myself.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.myself.dto.User;
import com.myself.dto.UserQueryCondition;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  MySelf
 * @create  2018/9/15
 * @desc User Controller 层
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 获取用户列表
     * @RequestMapping(value = "/user", method = RequestMethod.GET)
     * @RequestParam(name = "username",required = false,defaultValue = "tom") String nickname
     * @param condition {@link UserQueryCondition}
     * @return {@link List}
     */
    @GetMapping()
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition condition,@PageableDefault(page = 2,size = 17,sort = "username,asc") Pageable pageable){
        //反射工具
        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));

        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());

        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    /**
     * 获取用户信息 正则校验参数必须为数字
     * @RequestMapping(value = "/user/{id:\\d+}", method = RequestMethod.GET)
     * @param idxxx {@link String}
     * @return {@link User}
     */
    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable(name = "id") String idxxx){
        User user = new User();
        user.setUsername("tom");
        return user;
    }

}
