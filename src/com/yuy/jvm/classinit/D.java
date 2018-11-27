package com.yuy.jvm.classinit;

public class D {
    private static D d = new D();
    private static int a = 0;
    private static int b;
    private D(){
        a++;
        b++;
    }
    public static D getInstance(){
        return d;
    }
    public int getA(){
        return a;
    }
    public int getB(){
        return b;
    }
}
