package com.yuy.jvm.memory;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    private byte[]bs = new byte[1*1024*1024];
    public static void main(String[] args) {
        List list = new ArrayList();
        int num = 0;
        try{
            while(true){
                num++;
                list.add(new Test1());
            }

        }catch (Throwable err){
            System.out.println("num=" + num);
        }


//        System.out.println("max==" + Runtime.getRuntime().maxMemory()/1024/1024);
//        System.out.println("free==" + Runtime.getRuntime().freeMemory()/1024/1024);
//        System.out.println("total==" + Runtime.getRuntime().totalMemory()/1024/1024);
    }
}
