package com.mjw.common.aop;

import com.mjw.common.annotation.MjwDb;
import com.mysql.jdbc.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.mjw.common.configuration.DbLookupKeyContextHolder;

/**
 * @Description 切换数据源key的aop类
 * @Author MinJunWen
 * @Data 2018/11/23 15:15
 * @Version 1.0.0
 **/
@Aspect
@Component
public class ChangeDataSourceAop {

    private Logger logger = LoggerFactory.getLogger(ChangeDataSourceAop.class);

    /**
     * @Description 切面 针对所有service
     * @author MinJunWen
     * @date 2018/11/23 15:23
     */
    @Pointcut("execution( * com.mjw.business.*.service.*.*(..))")
    public void serviceCut(){};

    @Before("serviceCut()")
    public void changeDataSource(JoinPoint point) {
        String value = point.getTarget().getClass().getAnnotation(MjwDb.class).value().getValue();
        if(!StringUtils.isNullOrEmpty(value)){
            logger.info("switch db lookupkey ==>" + value);
            DbLookupKeyContextHolder.setDataSourceKey(value);
        }
    }

}
