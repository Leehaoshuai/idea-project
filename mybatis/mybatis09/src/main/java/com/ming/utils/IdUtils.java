package com.ming.utils;


import java.util.UUID;

@SuppressWarnings("all")
public class IdUtils {

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }


    public void test(){
        System.out.println(IdUtils.getId());
    }

}
