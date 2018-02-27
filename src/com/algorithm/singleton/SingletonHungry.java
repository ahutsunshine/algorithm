package com.algorithm.singleton;

/**
 * @author Kevin Yao
 */
public class SingletonHungry {
    private static SingletonHungry singleton = new SingletonHungry();

    private SingletonHungry() {
    }

    public static SingletonHungry getInstance() {
        return singleton;
    }
}
