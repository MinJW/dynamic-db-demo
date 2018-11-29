package com.mjw.business.order.service;

import com.mjw.business.order.model.User;

/**
 * @Description
 * @Author MinJunWen
 * @Data 2018/11/23 15:21
 * @Version 1.0.0
 **/
public interface OrderService {

    public User findUserById(int id);
}
