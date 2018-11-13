package com.yuy.jvm.asm;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Generator {
    public static void main(String[] args) throws IOException {
        ClassReader cr = new ClassReader("com/yuy/jvm/CC");
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        ClassVisitor cv = new MyClassVisitor(cw);
        cr.accept(cv,ClassReader.SKIP_DEBUG);
        byte[]data = cw.toByteArray();
        //输出
        File f = new File("out/production/JVMTest/com/yuy/jvm/CC.class");
        FileOutputStream fout = new FileOutputStream(f);
        fout.write(data);
        fout.close();
        System.out.println("now generator cc success");
    }

}
