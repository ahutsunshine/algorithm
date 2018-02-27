package com.algorithm.singleton;

/**
 * @author Kevin Yao
 */
public class SingletonNested {
    private SingletonNested() {
    }

    private static class Singleton {
        private static final SingletonNested INSTANCE = new SingletonNested();
    }

    public SingletonNested getInstance() {
        return Singleton.INSTANCE;
    }
}
