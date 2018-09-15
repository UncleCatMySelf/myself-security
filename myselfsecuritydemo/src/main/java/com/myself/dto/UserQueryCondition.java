package com.myself.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author  MySelf
 * @create  2018/9/15
 * @desc 用户查询条件信息Bean
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQueryCondition {

    /** 用户名 */
    private String username;

    /** 年龄 */
    private int age;

    /** 年龄范围 */
    private int ageTo;

    /** 其他 */
    private String xxx;

}
