package com.github.charlotte.jvm.c2_classloader;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class T006_MSBClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        File f = new File("/Users/macuser/code/backend/Clever-Charlotte/stack/java/jvm/src/main/java/", name.replace(".", "/").concat(".class"));
        File f = new File("/Users/macuser/code/backend/Clever-Charlotte/stack/java/jvm/target/classes", name.replace(".", "/").concat(".class"));
        try {
            FileInputStream fis = new FileInputStream(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;

            while ((b=fis.read()) !=0) {
                baos.write(b);
            }

            byte[] bytes = baos.toByteArray();
            baos.close();
            fis.close();//可以写的更加严谨

//            return defineClass(name, bytes, 0, bytes.length);
            return defineClass(name , bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name); //throws ClassNotFoundException
    }
//
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        int var3 = name.lastIndexOf(46);
        if (var3 != -1) {
            SecurityManager var4 = System.getSecurityManager();
            if (var4 != null) {
                var4.checkPackageAccess(name.substring(0, var3));
            }
        }

//        if (this.ucp.knownToNotExist(name)) {
            Class var5 = findClass(name);
            if (var5 != null) {
                return var5;
            } else {
                throw new ClassNotFoundException(name);
//            }
//        } else {
//            return super.loadClass(var1, var2);
//        }
//        File f = new File("/Users/macuser/code/backend/Clever-Charlotte/stack/java/jvm/target/classes", name.replace(".", "/").concat(".class"));
//        try {
//            FileInputStream fis = new FileInputStream(f);
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            int b = 0;
//
//            while ((b=fis.read()) !=0) {
//                baos.write(b);
//            }
//
//            byte[] bytes = baos.toByteArray();
//            baos.close();
//            fis.close();//可以写的更加严谨
//
//            return defineClass(name, bytes, 0, bytes.length);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        throw new ClassNotFoundException();
            }
    }

    public static void main(String[] args) throws Exception {
        ClassLoader l = new T006_MSBClassLoader();
//        Class clazz = l.loadClass("com.github.charlotte.jvm.c2_classloader.Hello");
        Class clazz = l.loadClass("com.github.charlotte.jvm.c2_classloader.Hello");
//        Class clazz1 = l.loadClass("com.github.charlotte.jvm.c2_classloader.Hello");

//        System.out.println(clazz == clazz1);

        Hello h = (Hello)clazz.newInstance();
        h.m();

        System.out.println(l.getClass().getClassLoader());
        System.out.println(l.getParent());


        System.out.println(getSystemClassLoader());
    }
}
