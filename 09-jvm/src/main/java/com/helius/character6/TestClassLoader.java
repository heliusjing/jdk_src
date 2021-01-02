package com.helius.character6;

import java.io.*;

/**
 *参考系统中已有的类加载器实现，继承classloader抽象类，
 * 只需要覆写findclass() method,
 * findclsss我们只要获取二进制字节码的字节流就okay了，
 * 然后用defineclass方法传入就行了。
 * 这个方法是真正用来实例化的，不需要我们操心
 * @Author Helius
 * @Create 2020-08-01-4:01 下午
 */
public class TestClassLoader extends ClassLoader {
    //自定义class扫描路径
    private String classPath;

    public TestClassLoader(String classPath) {
        this.classPath = classPath;
    }

    //覆写ClassLoader的findClass方法
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getDate(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name,classData,0,classData.length);
        }

    }

    private byte[] getDate(String name) {
        //拼接clsss目标路径
        String path =
                classPath + File.separatorChar + name.replace(".",File.separatorChar + ".class" );
        try {
            FileInputStream is = new FileInputStream(path);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int num = 0;
            while ((num = is.read(buffer)) != -1) {
                stream.write(buffer,0 ,num);
            }
            return stream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }







}
