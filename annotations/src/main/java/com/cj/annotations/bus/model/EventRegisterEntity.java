package com.cj.annotations.bus.model;

/**
 * Author:chris - jason
 * Date:2019-08-23.
 * Package:com.cj.annontations.bus.model
 */
public class EventRegisterEntity {

    public EventRegisterEntity(String fieldName, String className, boolean asList) {
        this.fieldName = fieldName;
        this.className = className;
        this.asList = asList;
    }

    private String fieldName;//@EventRegister注解的字段名
    private String className = "java.lang.Object";//@EventRegister注解的type()值，默认为Object类型
    private boolean asList = false;//是否作为集合

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public boolean isAsList() {
        return asList;
    }

    public void setAsList(boolean asList) {
        this.asList = asList;
    }
}
