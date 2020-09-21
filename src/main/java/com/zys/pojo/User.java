package com.zys.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program: ssm
 * @description: UserPojo
 * @author: xiaozhang6666
 * @create: 2020-09-14 16:52
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String sex;
    private Date birthday;
    private String address;
}
