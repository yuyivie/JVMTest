package com.yuy.jvm.gc;

public class User {
    private byte[] bs = new byte[1024*244];
    private String userId;
    public User(String userId){
        this.userId = userId;
    }
    public String toString(){
        return "userId=" + userId;
    }
    public String getString(){
        return "hhhhhhhh";
    }
    /**
     * 虚拟机垃圾回收的时候会调finalize方法
     */
    public void finalize(){
        System.out.println("now  finalize userId==" +userId);
    }
}
