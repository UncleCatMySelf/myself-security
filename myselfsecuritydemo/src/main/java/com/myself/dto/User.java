package com.myself.dto;


import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author  MySelf
 * @create  2018/9/15
 * @desc User Bean
 **/
public class User {

    /** 用户简单视图 */
    public interface UserSimpleView {}

    /** 用户详情视图 */
    public interface UserDetailView extends UserSimpleView {}

    /** 用户名 */
    private String username;

    /** 用户密码 */
    private String password;

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
