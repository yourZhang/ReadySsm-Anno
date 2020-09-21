package com.zys.mapper;

import com.zys.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
    Integer saveUser(User user);
}
