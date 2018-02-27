package com.algorithm.singleton;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * @author Kevin Yao
 */
public class SingletonPreventReflectAndSerialize implements Serializable {
    private static boolean flag = false;
    private static SingletonPreventReflectAndSerialize singleton = new SingletonPreventReflectAndSerialize();

    private SingletonPreventReflectAndSerialize() {
        if (!flag) {
            flag = true;
        } else {
            try {
                throw new Exception("Cannot create duplicate instance.");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static SingletonPreventReflectAndSerialize getInstance() {
        return singleton;
    }

    /**
     * do not use  private SingletonPreventReflectAndSerialize readResolve(),it not works.
     */
    private Object readResolve() {
        return singleton;
    }

    public static void main(String[] args) throws Exception {
        //use reflect to get instance
        Constructor<SingletonPreventReflectAndSerialize> c = SingletonPreventReflectAndSerialize.class.getDeclaredConstructor();
        c.setAccessible(true);
        SingletonPreventReflectAndSerialize singleton = c.newInstance();
        System.out.println(singleton == getInstance());

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("temp"));
        out.writeObject(getInstance());
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("temp"));
        SingletonPreventReflectAndSerialize s = (SingletonPreventReflectAndSerialize) in.readObject();
        System.out.println(s == getInstance());
    }
}
