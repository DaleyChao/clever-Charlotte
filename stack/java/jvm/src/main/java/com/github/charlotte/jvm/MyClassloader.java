package com.github.charlotte.jvm;

/**
 * @author Daniel
 */
public class MyClassloader {

    public static void main(String[] args) {
        try {
           Class classa =  MyClassloader.class.getClassLoader().loadClass("com.github.charlotte.jvm.A");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
