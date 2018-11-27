package com.yuy.jvm.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试垃圾收集器。
 * 1.测试Serial垃圾收集器：VM options： -Xms2m -Xmx4m -XX:+PrintGCDetails -XX:+UseSerialGC
 *2.测试ParNew 垃圾收集器：VM options： -Xms2m -Xmx4m -XX:+PrintGCDetails -XX:+UseParNewGC
 * 3.测试CMS垃圾收集器：VM options：-Xms2m -Xmx4m -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC
 * 4.测试G1垃圾收集器：VM options：-Xms2m -Xmx4m -XX:+PrintGCDetails -XX:+UseG1GC
 */
public class Test2 {
    private byte[]bs = new byte[100*1024];

    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i =0;i<100;i++){
            list.add(new Test2());
        }
    }
}
