package com.chq.designModel;

/**
 * 默认使用懒汉模式实现，双重锁定检查
 *
 * @author chenghq
 */
public class Singleton {
    private static volatile Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                    return singleton;
                } else {
                    return singleton;
                }
            }
        } else {
            return singleton;
        }
    }
}

class HungrySingleton {
    private static HungrySingleton singleton = new HungrySingleton();

    public static HungrySingleton getSingletom() {
        return singleton;
    }
}