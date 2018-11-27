package com.yuy.jvm.classloader;


import java.io.*;

public class MyClassLoader extends ClassLoader {
    private String name;
    public MyClassLoader(ClassLoader parent,String name){
        super(parent);
        this.name = name;
    }
    public MyClassLoader(String name){
        this.name = name;
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);
        return this.defineClass(name,data,0,data.length);
    }
    private byte[] loadClassData(String name){
        InputStream in = null;
        byte[]data = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        name = name.replace(".","/");
        try {
            in = new FileInputStream(new File("D:/Workspaces/idea_git/" + name +".class"));
            int a = 0;
            while((a=in.read())!= -1){
                baos.write(a);
            }
            data = baos.toByteArray();
        }catch (Exception err){
            err.printStackTrace();
        }finally {
            if(in !=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return data;
    }
}

