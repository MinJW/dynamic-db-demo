package com.mjw.business.wallet.dao;

import com.mjw.business.wallet.model.User;

/**
 * @Description
 * @Author MinJunWen
 * @Data 2018/11/17 15:35
 * @Version 1.0.0
 **/
public interface WalletUserDao {

    User findUserById(int id);
}
