package com.algorithm.singleton;

/**
 * @author Kevin Yao
 */
public class SingletonLazyDoubleLockCheck {
    private volatile static SingletonLazyDoubleLockCheck singleton;

    private SingletonLazyDoubleLockCheck() {
    }

    public static SingletonLazyDoubleLockCheck getInstance() {
        if (singleton == null) {
            synchronized (SingletonLazyDoubleLockCheck.class) {
                if (singleton == null) {
                    singleton = new SingletonLazyDoubleLockCheck();
                }
            }
        }
        return singleton;
    }

}
