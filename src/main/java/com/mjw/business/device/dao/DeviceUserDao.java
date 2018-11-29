package com.mjw.business.device.dao;

import com.mjw.business.device.model.User;

/**
 * @Description
 * @Author MinJunWen
 * @Data 2018/11/17 15:35
 * @Version 1.0.0
 **/
public interface DeviceUserDao {

    User findUserById(int id);
}
