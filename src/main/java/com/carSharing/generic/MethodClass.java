package com.carSharing.generic;

public abstract class MethodClass {
    protected  String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    protected String getCurrentClassName() {
        return this.getClass().getSimpleName();
    }
}
