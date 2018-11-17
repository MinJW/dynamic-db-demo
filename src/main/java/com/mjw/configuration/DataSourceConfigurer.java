package com.mjw.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @Description
 * @Author MinJunWen
 * @Data 2018/11/17 15:23
 * @Version 1.0.0
 **/
@Configuration
public class DataSourceConfigurer {

    private Logger logger = LoggerFactory.getLogger(DataSourceConfigurer.class);

    @Bean
    @ConfigurationProperties(prefix = "com.mjw.datasource.db")
    public DataSource dataSource(){
        logger.debug("dataSource init ...");
        DruidDataSource build = DruidDataSourceBuilder.create().build();
        return build;
    }

    @Bean
    @ConfigurationProperties(prefix = "mybatis")
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        logger.debug("sqlSessionFactoryBean init ...");
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        return sqlSessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        logger.debug("transactionManager init ...");
        return new DataSourceTransactionManager(dataSource());
    }
}
