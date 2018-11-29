package com.mjw.business.order.dao;

import com.mjw.business.order.model.User;

/**
 * @Description
 * @Author MinJunWen
 * @Data 2018/11/17 15:35
 * @Version 1.0.0
 **/
public interface OrderUserDao {

    User findUserById(int id);
}
