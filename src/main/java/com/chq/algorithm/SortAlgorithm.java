package com.chq.algorithm;

import java.util.Arrays;

/**
 * @author chenghq
 */
public class SortAlgorithm {

    public static void main(String[] args) {
        int[] arr = {3, 12, 3123, 42, 34, 3, 3, 5, 5, 5, 23, 52, 3, 23, 4123};
        heapSort(arr);
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        //先从N/2+1进行调整
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapSort(arr, i, arr.length);
        }

        //然后交换0和数组后面元素的位置，再执行sink操作，完成堆排序
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapSort(arr, 0, i);
        }

        System.out.println(Arrays.toString(arr));
    }

    //最核心的一点就是建立一个大顶堆
    public static void heapSort(int[] arr, int index, int len) {
        int maxChild = getLeftChild(index);
        for (; maxChild < len; maxChild = getLeftChild(index)) {
            if (maxChild + 1 < len && arr[maxChild + 1] > arr[maxChild]) {
                ++maxChild;
            }
            if (arr[maxChild] > arr[index]) {
                swap(arr, maxChild, index);
                index = maxChild;
            } else {
                break;
            }
        }
    }

    public static int getLeftChild(int index) {
        return 2 * index + 1;
    }

    public static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
