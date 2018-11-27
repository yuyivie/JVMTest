package com.yuy.jvm.classloader;

public class Impl implements Api {
    @Override
    public int add(int a, int b) {
        System.out.println("addd a ==" + a + " , b ==" + b);
        return a + b ;
    }
}
