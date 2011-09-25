package com.syspeak.makereap.system.log.entity;


public enum AccessType {
    LOGIN("登录")
    //,LOGOUT("登出")
    , CREATE("创建"), UPDATE("更新"), DELETE("删除")
    //,STARTUP("系统启动")
    //,STOP("系统停止")
    ;

    private String value;

    AccessType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return this.value;
    }
}
