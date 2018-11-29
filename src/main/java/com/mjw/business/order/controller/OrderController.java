package com.mjw.business.order.controller;

import com.mjw.business.order.model.User;
import com.mjw.business.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author MinJunWen
 * @Data 2018/11/23 17:46
 * @Version 1.0.0
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("")
    public User findUserById(int id){
        return orderService.findUserById(id);
    }

}
