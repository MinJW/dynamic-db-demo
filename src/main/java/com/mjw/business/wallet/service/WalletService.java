package com.mjw.business.wallet.service;

import com.mjw.business.wallet.model.User;

/**
 * @Description
 * @Author MinJunWen
 * @Data 2018/11/23 15:21
 * @Version 1.0.0
 **/
public interface WalletService {

    public User findUserById(int id);
}
