package com.mjw.configuration;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Description
 * @Author MinJunWen
 * @Data 2018/11/17 16:22
 * @Version 1.0.0
 **/
public class MyDynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return "db2";
    }

}
