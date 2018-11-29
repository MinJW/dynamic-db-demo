package com.mjw.common.enums;

/**
 * @Description
 * @Author MinJunWen
 * @Data 2018/11/29 11:52
 * @Version 1.0.0
 **/
public enum MjwDbEnum {

    DEVICE("device"),ORDER("order"),USER("user"),WALLET("wallet");

    private String value;
    MjwDbEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
