package com.carSharing.generic;

public  class Utils {

    public static <T> boolean  isNull(T t){

       return t == null;
    }

    public static <T> boolean isEmpty(T t){

        return t.toString().isEmpty();
    }
}
