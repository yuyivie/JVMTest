package com.yuy.jvm;

public class Main {

    public static void main(String[] args) {
        int a = 1000 ,b = 2000,c =3000 ,d = 4000 ,e = 5000 ,f = 6000;
        int h = a + c + d + e + f/b;
        if(h>1000){
            System.out.println("h>1000");
        }
        StringBuffer stringBuffer = new StringBuffer("JVMTeset");
       int[] y =  new int[]{11,22,33,44,55};
        System.out.println(h);
        System.out.println(stringBuffer.toString());
    }
}
