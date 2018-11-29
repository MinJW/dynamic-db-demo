package com.mjw.business.wallet.controller;

import com.mjw.business.wallet.model.User;
import com.mjw.business.wallet.service.WalletService;
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
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @RequestMapping("")
    public User findUserById(int id){
        return walletService.findUserById(id);
    }

}
