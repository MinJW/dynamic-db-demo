package com.mjw.common.configuration;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author MinJunWen
 * @Data 2018/11/17 15:23
 * @Version 1.0.0
 **/
@Configuration
public class DataSourceConfigurer {

    private Logger logger = LoggerFactory.getLogger(DataSourceConfigurer.class);

    @Bean(name = "user")
    @Primary
    @ConfigurationProperties(prefix = "com.mjw.datasource.user")
    public DataSource userDataSource(){
        logger.debug("userDataSource init ...");
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "wallet")
    @ConfigurationProperties(prefix = "com.mjw.datasource.wallet")
    public DataSource walletDataSource(){
        logger.debug("walletDataSource init ...");
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "device")
    @ConfigurationProperties(prefix = "com.mjw.datasource.device")
    public DataSource deviceDataSource(){
        logger.debug("deviceDataSource init ...");
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "order")
    @ConfigurationProperties(prefix = "com.mjw.datasource.order")
    public DataSource orderDataSource(){
        logger.debug("orderDataSource init ...");
        return DruidDataSourceBuilder.create().build();
    }


    /**
     * @Title
     * @Description 动态数据初始化
     * @param
     * @return javax.sql.DataSource
     * @throw
     * @author MinJunWen
     * @date 2018/11/17 16:25
     */
    @Bean
    public DataSource dynamicDataSource(){
        MyDynamicDataSource myDynamicDataSource = new MyDynamicDataSource();


        Map<Object,Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put("user",userDataSource());
        dataSourceMap.put("wallet",walletDataSource());
        dataSourceMap.put("device",deviceDataSource());
        dataSourceMap.put("order",orderDataSource());

        //设置默认的dataSource
        myDynamicDataSource.setDefaultTargetDataSource(userDataSource());

        //设置数据源map
        myDynamicDataSource.setTargetDataSources(dataSourceMap);

        return myDynamicDataSource;
    }

    @Bean
    @ConfigurationProperties(prefix = "mybatis")
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        logger.debug("sqlSessionFactoryBean init ...");
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource());
        return sqlSessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        logger.debug("transactionManager init ...");
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
