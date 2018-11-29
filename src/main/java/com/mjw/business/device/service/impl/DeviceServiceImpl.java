package com.mjw.business.device.service.impl;

import com.mjw.business.device.dao.DeviceUserDao;
import com.mjw.business.device.model.User;
import com.mjw.business.device.service.DeviceService;
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
@MjwDb(MjwDbEnum.DEVICE)
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceUserDao deviceUserDao;

    public User findUserById(int id){
        return deviceUserDao.findUserById(id);
    }

}
