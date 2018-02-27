package com.algorithm.singleton;

/**
 * @author Kevin Yao
 */
public class SingletonLazyLock {
    private static SingletonLazyLock singleton;

    private SingletonLazyLock() {
    }

    public static synchronized SingletonLazyLock getInstance() {
        if (singleton == null) {
            singleton = new SingletonLazyLock();
        }
        return singleton;
    }
}