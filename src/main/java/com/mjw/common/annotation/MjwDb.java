package com.mjw.common.annotation;

import com.mjw.common.enums.MjwDbEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description
 * @Author MinJunWen
 * @Data 2018/11/29 9:44
 * @Version 1.0.0
 **/
@Target({  ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface MjwDb {

    MjwDbEnum value();
}
