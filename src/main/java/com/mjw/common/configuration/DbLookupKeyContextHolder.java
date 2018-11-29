package com.mjw.common.configuration;

/**
 * @Description
 * @Author MinJunWen
 * @Data 2018/11/23 14:41
 * @Version 1.0.0
 **/
public class DbLookupKeyContextHolder {

    /**
     * @Description 存放当前线程线程 选择数据链接 key
     * @author MinJunWen
     * @date 2018/11/23 14:42
     */
    private static final ThreadLocal<String> CURRENT_LOOKUP_KEY = new ThreadLocal<>();

    /**
     * @Description 设置当前选择数据库的key
     * @author MinJunWen
     * @date 2018/11/23 14:42
     */
    public static void setDataSourceKey(String lookupKey){
        CURRENT_LOOKUP_KEY.set(lookupKey);
    }

    /**
     * @Description 获取当前选择数据库的key
     * @author MinJunWen
     * @date 2018/11/23 15:34
     */
    public static String getDataSourceKey(){
        return CURRENT_LOOKUP_KEY.get();
    }

}
