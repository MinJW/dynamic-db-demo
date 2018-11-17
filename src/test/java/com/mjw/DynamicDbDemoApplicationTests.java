package com.mjw;

import com.mjw.mapper.UserDao;
import com.mjw.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.mjw.mapper")
public class DynamicDbDemoApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads() {
        User user = userDao.findUserById(1);

        System.out.println(user);
    }

}
