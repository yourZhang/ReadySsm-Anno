package com.zys.service.impl;

import com.zys.mapper.UserMapper;
import com.zys.pojo.User;
import com.zys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: ssm
 * @description:
 * @author: xiaozhang6666
 * @create: 2020-09-14 17:47
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findAll() {
        List<User> all = userMapper.findAll();
        return all;
    }

    @Override
    @Transactional(transactionManager = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public Integer saveUser(User user) {
        Integer integer = userMapper.saveUser(user);
        int i = 1 / 0;
        System.out.println(integer);
        return integer;
    }
}
