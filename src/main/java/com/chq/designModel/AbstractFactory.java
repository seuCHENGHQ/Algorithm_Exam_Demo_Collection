package com.chq.designModel;

public class AbstractFactory {
    public static void main(String[] args) {
        FruitFactory fruitFactory = new AppleFactory();
        fruitFactory.getFruit().show();
        fruitFactory = new BananaFactory();
        fruitFactory.getFruit().show();
    }
}

interface FruitFactory {
    Fruit getFruit();
}

abstract class Fruit {
    public abstract void show();
}

class AppleFactory implements FruitFactory {
    @Override
    public Fruit getFruit() {
        return new Apple();
    }
}

class BananaFactory implements FruitFactory {
    @Override
    public Fruit getFruit() {
        return new Banana();
    }
}

class Apple extends Fruit {
    @Override
    public void show() {
        System.out.println("this is a apple");
    }
}

class Banana extends Fruit {
    @Override
    public void show() {
        System.out.println("this is a banana");
    }
}