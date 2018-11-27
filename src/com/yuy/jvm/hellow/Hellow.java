package com.yuy.jvm.hellow;

public class Hellow {
    private static String msg = "good morning";
    public Hellow(){
        System.out.println("hh now in hellow ....");
    }
    public static void main(String[] args) {
        System.out.println("msg==" + msg);
    }

    private int a = 100;
    public int getAAndB(int b){
        if (b > 5) {
            return a +b ;
        }
        return a;
    }
}
