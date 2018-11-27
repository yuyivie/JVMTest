package com.yuy.jvm.gc;

import java.lang.ref.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 引用分为：
 * 强引用（Strong Reference）、
 * 软引用（Soft Reference）、
 * 弱引用（Weak Reference）、
 * 虚引用（Phantom Reference）
 * 这4中引用强度依次逐渐减弱
 *
 * 测试的时候需配置VM options： -Xms2m -Xmx4m -XX:+PrintGCDetails
 */
public class Test1 {
    private static ReferenceQueue<User> rq = new ReferenceQueue<User>();

    private static void printQueue(){
        System.out.println("11111111111");
        Reference<? extends User> obj = rq.poll();
       // System.out.println("ojb=="+ obj.toString());
        if(obj != null){
            System.out.println("the gc object reference ===" +obj.get());
        }
    }
    //测试软引用
    private static void testSoftReference() throws InterruptedException {
        List<SoftReference<User>> srUserList = new ArrayList<SoftReference<User>>();
        for(int i=0;i<10;i++){
            SoftReference<User> sr = new SoftReference<User>(new User("soft " + i),rq);
            System.out.println("now the user1=="+ sr.get());
            srUserList.add(sr);
        }
        System.gc();
        Thread.sleep(1000L);
        printQueue();
        User user = srUserList.get(0).get();//当分配的堆内存快满时会回收对象，此时user为空
        if(user != null){
            System.out.println("堆内存足够，不会触发gc user对象的值为==" + user.getString());
        }else{
            System.out.println("堆内存不够了，SoftReference会在此时被回收。。所以user为null");
        }

    }
    //测试弱引用
    private static void testWeakReference() throws InterruptedException {
        List<WeakReference<User>> srUserList = new ArrayList<WeakReference<User>>();
        for(int i=0;i<10;i++){
            WeakReference<User> sr = new WeakReference<User>(new User("weak " + i),rq);
            User user = sr.get();

            System.out.println("now the user1=="+ sr.get());
            srUserList.add(sr);
        }
        System.gc();
        Thread.sleep(1000L);
        printQueue();
       /* User user = srUserList.get(0).get();
        System.out.println("被回收后的对象的值为==" + user.getString());;*/
    }
    //测试虚应用   (为一个对象设置虚应用关联的唯一目的就是能在这个对象呗收集器回收时收到一个系统通知。)
    private static void testPhantomReference() throws InterruptedException {
        List<PhantomReference<User>> srUserList = new ArrayList<PhantomReference<User>>();
        for(int i=0;i<10;i++){
            PhantomReference<User> sr = new PhantomReference<User>(new User("weak " + i),rq); //每次垃圾回收会自动往ReferenceQueue里面添加值，通过.poll()方法获取。。
            System.out.println("now the user1=="+ sr.get());//虚引用是get不到值的。
            srUserList.add(sr);
        }
        System.gc();
        Thread.sleep(1000L);
        printQueue();
       /* User user = srUserList.get(0).get();
        System.out.println("被回收后的对象的值为==" + user.getString());;*/
    }
    public static void main(String[] args) throws InterruptedException {
        //testSoftReference();
       // testWeakReference();
        testPhantomReference();
    }


}
