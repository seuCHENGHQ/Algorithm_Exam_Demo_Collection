package com.chq.algorithm;

import java.util.PriorityQueue;

public class MedianOfDataFlow {
    //最小堆，保存数据流右半边的数据
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //最大堆，保存数据流左半边的数据
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((Integer i1, Integer i2) -> {
        return i2 - i1;
    });

    public static void main(String[] args) {

    }

    public void insert(Integer num) {
        Integer size = minHeap.size() + maxHeap.size();
        if (size % 2 == 0) {
            maxHeap.offer(num);
            Integer temp = maxHeap.poll();
            minHeap.offer(temp);
        } else {
            minHeap.offer(num);
            Integer temp = minHeap.poll();
            maxHeap.offer(temp);
        }
    }

    public Integer getMedian() {
        Integer size = minHeap.size() + maxHeap.size();
        if (size == 0) {
            throw new RuntimeException("");
        }
        if (size % 2 == 0) {
            return (minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            return minHeap.peek();
        }
    }
}
