package com.mjw.business.wallet.service.impl;

import com.mjw.business.wallet.dao.WalletUserDao;
import com.mjw.business.wallet.model.User;
import com.mjw.business.wallet.service.WalletService;
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
@MjwDb(MjwDbEnum.WALLET)
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletUserDao walletUserDao;

    public User findUserById(int id){
        return walletUserDao.findUserById(id);
    }

}
