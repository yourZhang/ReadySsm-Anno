package com.zys.service;

import com.zys.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<User> findAll();
    Integer saveUser(User user);
}
