package com.mjw.business.device.service;

import com.mjw.business.device.model.User;

/**
 * @Description
 * @Author MinJunWen
 * @Data 2018/11/23 15:21
 * @Version 1.0.0
 **/
public interface DeviceService {

    public User findUserById(int id);

    void update(User user);
}
