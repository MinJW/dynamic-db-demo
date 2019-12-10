package com.mjw.business.user.facade;

import com.mjw.business.device.dao.DeviceUserDao;
import com.mjw.business.device.service.DeviceService;
import com.mjw.business.user.dao.UserDao;
import com.mjw.business.user.model.User;
import com.mjw.business.user.service.UserService;
import com.mjw.common.configuration.DbLookupKeyContextHolder;
import com.mjw.common.enums.MjwDbEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @Description
 * @Author MinJunWen
 * @Data 2019/12/10 14:44
 * @Version 1.0.0
 **/
@Component
public class UserFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private DeviceService deviceService;

    //@Autowired
    //private DataSourceTransactionManager dataSourceTransactionManager;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Transactional
    public void test(){
        User user1 = userService.findUserById(1);
        user1.setName("user1111");
        userService.update(user1);

        DbLookupKeyContextHolder.setDataSourceKey(MjwDbEnum.DEVICE.getValue());
        DefaultTransactionDefinition transDefinition = new DefaultTransactionDefinition();
        //开启新事物
        transDefinition.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transDefinition);

        com.mjw.business.device.model.User deviceUser = deviceService.findUserById(1);
        deviceUser.setName("device11111");
        deviceService.update(deviceUser);

        platformTransactionManager.commit(transactionStatus);

        user1.setName("user222");
        userService.update(user1);

        System.out.println(user1);
        System.out.println(deviceUser);
    }

}
