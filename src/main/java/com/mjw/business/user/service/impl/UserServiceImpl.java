package com.mjw.business.user.service.impl;

import com.mjw.business.user.dao.UserDao;
import com.mjw.business.user.model.User;
import com.mjw.business.user.service.UserService;
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
@MjwDb(MjwDbEnum.USER)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User findUserById(int id){
        return userDao.findUserById(id);
    }

}
