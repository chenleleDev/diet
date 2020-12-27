package com.javaclimb.util;

import java.util.HashMap;

public class MapWrapperUtils extends HashMap<String, Object> {
    public static String KEY_USER_ID = "userIdForToken";//用户的id
    public static String KEY_EXP = "expForToken";//过期日期时间戳
    public static String KEY_USER_TYPE = "userTypeForToken";//用户类型
    public static String USER_TYPE_USER = "typeUser";//类型--用户
    public static String USER_TYPE_MERCHANT = "typeMerchant";//类型--商家医生
    public static String KEY_TOKENDATA = "tokenData";//token数据


    @Override
    public MapWrapperUtils put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public static MapWrapperUtils builder(String key, Object value) {
        MapWrapperUtils wrapperUtils = new MapWrapperUtils();
        wrapperUtils.put(key, value);
        return wrapperUtils;
    }
}
