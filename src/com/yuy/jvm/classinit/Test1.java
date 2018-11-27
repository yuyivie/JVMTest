package com.yuy.jvm.classinit;

import com.yuy.jvm.classloader.MyClassLoader;

public class Test1 {
    static{
        System.out.println("now in teset1");//JVM启动的时候运行的主类
    }
    public static void main(String[] args) throws ClassNotFoundException {
      //  A a = new A();//创建类实例 会初始化类

        // Class.forName("com.yuy.jvm.classinit.A");//反射某个类 会初始化类

        /*调用Classloader类的loadClass方法来装载一个类，
        并不会初始化这个类，不是对类的主 动使用*/
       // MyClassLoader myloader = new MyClassLoader("myloader");
       // myloader.loadClass("com.yuy.jvm.classinit.A");

       // int a = A.abc;//访问某个类或接口的静态变量 会初始化类

      //  A.getAbc();//调用类的静态方法  会初始化类

       // C c = new C();//初始化某个类的子类，而父类还没有初始化

       /* D d = D.getInstance();
        System.out.println("D.a===" + d.getA());
        System.out.println("D.b===" + d.getB());*/

      // C.getAbc();//当调用父类的静态方法是  父类会被初始化 而子类不会被初始化
        String a = C.MSG;//直接访问类的常量 也不会初始化类
        System.out.println("over...");

    }
}
