package com.yuy.jvm.classloader;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Test1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String str = "123";
        //java程序不能直接应用启动类加载器，直接设置classloader为null，默认就使用启动类加载器
        System.out.println("String classloader=" + str.getClass().getClassLoader());//String 类为启动类加载器(BootStractClassLoader)加载

        Test1 t1 = new Test1();
        System.out.println("Test1 classloader==" + t1.getClass().getClassLoader());//Test1 类为应用程序类加载器(AppClassLoader)加载

        System.out.println("Test1 classloader parent==" + t1.getClass().getClassLoader().getParent());//获取父类加载器
        System.out.println("Test1 classloader parent parent==" + t1.getClass().getClassLoader().getParent().getParent());//获取父类的父类加载器。，
        MyClassLoader myLoader = new MyClassLoader("myloader1");
        Class h2 = myLoader.loadClass("com.yuy.jvm.hellow.Hellow");
        System.out.println("Hellow222 classloader ==" + h2.getClassLoader());
        System.out.println("Hellow222 classloader parent==" + h2.getClassLoader().getParent());
        System.out.println("Hellow222 classloader parent parent==" + h2.getClassLoader().getParent().getParent());
        System.out.println("Hellow222 classloader parent parent parent==" + h2.getClassLoader().getParent().getParent().getParent());
        h2.newInstance();
        // ===============破坏双亲委派模型
        Thread.currentThread().setContextClassLoader(myLoader);//通过设置线程上下问破坏双亲委派。。
        Api api  = (Api)Thread.currentThread().getContextClassLoader().loadClass("com.yuy.jvm.classloader.Impl").newInstance();
        int result = api.add(4, 3);
        System.out.println("result==" + result  + " api classloader == " + api.getClass().getClassLoader());
        //=================

    }
}
