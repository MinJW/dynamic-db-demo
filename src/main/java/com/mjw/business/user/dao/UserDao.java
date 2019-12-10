package com.mjw.business.user.dao;

import com.mjw.business.user.model.User;


/**
 * @Description
 * @Author MinJunWen
 * @Data 2018/11/17 15:35
 * @Version 1.0.0
 **/
public interface UserDao {

    User findUserById(int id);

    void update(User user);
}
