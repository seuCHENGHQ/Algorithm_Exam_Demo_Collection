package com.chq.exam;

import java.util.LinkedHashMap;
import java.util.Map;

public class Xinlang1 {
    private LinkedHashMap<Integer, Integer> map;
    private int MAX_CAPACITY;

    public Xinlang1(int capacity) {
        this.MAX_CAPACITY = capacity;
        this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > MAX_CAPACITY;
            }
        };
    }

    public static void main(String[] args) {
        Xinlang1 x = new Xinlang1(2);
        x.put(1, 1);
        x.put(2, 2);
        System.out.println(x.get(1));
        x.put(3, 3);
    }

    public int get(int key) {
        Integer i = map.get(key);
        i.intValue();
        return this.map.get(key);
    }

    public void put(int key, int value) {
        this.map.put(key, value);
    }
}
