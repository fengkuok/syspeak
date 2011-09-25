package com.syspeak.makereap.system.identity.entity;

public enum IdentityType {
    CLASS("CLASS");                 //class 全路径名 + id


    private String value;

    IdentityType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return this.value;
    }
}
