package com.zys.controller;

import com.zys.pojo.User;
import com.zys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: ssm
 * @description: user
 * @author: xiaozhang6666
 * @create: 2020-09-14 16:51
 **/
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("findAll")
    @ResponseBody
    public List<User> findAll() {
        List<User> all = userService.findAll();
        return all;
    }
}
