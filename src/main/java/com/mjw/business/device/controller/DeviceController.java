package com.mjw.business.device.controller;

import com.mjw.business.device.model.User;
import com.mjw.business.device.service.DeviceService;
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
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping("")
    public User findUserById(int id){
        return deviceService.findUserById(id);
    }

}
