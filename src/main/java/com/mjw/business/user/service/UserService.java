package com.mjw.business.user.service;

import com.mjw.business.user.model.User;

/**
 * @Description
 * @Author MinJunWen
 * @Data 2018/11/23 15:21
 * @Version 1.0.0
 **/
public interface UserService {

    public User findUserById(int id);
}
