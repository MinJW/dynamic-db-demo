package com.mjw.business.order.service.impl;

import com.mjw.business.order.dao.OrderUserDao;
import com.mjw.business.order.model.User;
import com.mjw.business.order.service.OrderService;
import com.mjw.common.annotation.MjwDb;
import com.mjw.common.enums.MjwDbEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author MinJunWen
 * @Data 2018/11/23 17:34
 * @Version 1.0.0
 **/
@Service
@MjwDb(MjwDbEnum.ORDER)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderUserDao orderUserDao;

    public User findUserById(int id){
        return orderUserDao.findUserById(id);
    }

}
