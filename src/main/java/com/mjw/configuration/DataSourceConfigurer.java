package com.mjw.configuration;

import com.alibaba.druid.pool.DruidDataSource;
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

    @Bean(name = "db")
    @Primary
    @ConfigurationProperties(prefix = "com.mjw.datasource.db")
    public DataSource dbDataSource(){
        logger.debug("dbDataSource init ...");
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "db1")
    @ConfigurationProperties(prefix = "com.mjw.datasource.db1")
    public DataSource db1DataSource(){
        logger.debug("db1DataSource init ...");
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "db2")
    @ConfigurationProperties(prefix = "com.mjw.datasource.db2")
    public DataSource db2DataSource(){
        logger.debug("db2DataSource init ...");
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
        dataSourceMap.put("db",dbDataSource());
        dataSourceMap.put("db1",db1DataSource());
        dataSourceMap.put("db2",db2DataSource());

        myDynamicDataSource.setDefaultTargetDataSource(dbDataSource());
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
