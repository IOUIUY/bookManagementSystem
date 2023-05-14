package com.aic.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {

    //用于从map 中注入 bean 的属性
    public static <T> T copyParamToBean(T bean , Map m){
        try {
            BeanUtils.populate(bean,m);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return bean;
    }

    public static int parseInt(String strInt , int defaultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
}