package com.carSharing.entity.generic;

public abstract class MethodClass {
    protected String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}
