package com.chq.algorithm;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class LRU {
    private LinkedHashMap<Integer, Integer> map;
    private int MAX_CAPACITY;

    public LRU(int capacity) {
        this.MAX_CAPACITY = capacity;
        this.map = new LinkedHashMap<>();
    }

    public Integer get(Integer key) {
        return map.get(key);
    }

    public void put(Integer key, Integer val) {
        if (map.containsKey(key)) {
            map.remove(key);
        }
        if (map.size() == MAX_CAPACITY) {
            Set<Integer> keySet = map.keySet();
            //因为LinkedHashMap没有removeFirst这种方法，因此需要使用迭代器来遍历到第一个元素
            Iterator<Integer> iterator = keySet.iterator();
            map.remove(iterator.next());
        }
        map.put(key, val);
    }
}
