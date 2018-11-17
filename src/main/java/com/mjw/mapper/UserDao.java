package com.mjw.mapper;

import com.mjw.model.User;

import java.util.List;

/**
 * @Description
 * @Author MinJunWen
 * @Data 2018/11/17 15:35
 * @Version 1.0.0
 **/
public interface UserDao {

    List<User> userList();

    User findUserById(int id);
}
