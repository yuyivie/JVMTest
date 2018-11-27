package com.yuy.jvm.classinit;

public class A {
    public static int abc = 100 ;
    static{
        System.out.println("now in A static block");
    }
    public static int getAbc(){
        return abc;
    }
}
