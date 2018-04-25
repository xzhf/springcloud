package com.xx.springcloud.zuul.bean;

/**
 * 过滤器类型
 * @author xuzhifan
 * @version 1.0
 * @since 2018/4/25
 */
public enum FilterType {
    //路由之前,路由之时,路由之后,发送错误调用
    pre,routing,post,error
}
