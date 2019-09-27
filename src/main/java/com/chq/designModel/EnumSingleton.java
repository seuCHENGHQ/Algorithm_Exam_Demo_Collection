package com.chq.designModel;

/**
 * 使用枚举实现单例模式
 *
 * @author chenghq
 */
public enum EnumSingleton {
    SINGLETON;

    /**
     * 枚举类只是个特殊的类，也可以在里面写业务逻辑的
     *
     * @return
     */
    public int count() {
        return 1;
    }

    public EnumSingleton getSingleton() {
        return SINGLETON;
    }
}
