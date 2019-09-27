package com.chq.utils;

public class BinarySearchUtil {
    /**
     * C++中存在的两个方法，用java实现一下
     * ower_bound算法要求在已经按照非递减顺序排序的数组中找到第一个大于等于给定值key的那个数的索引，
     * 其基本实现原理是二分查找
     */
    public static int lowerBound(int[] nums, int l, int r, int target) {
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] >= target) r = m;
            else l = m + 1;
        }
        return l;
    }

    /**
     * upper_bound函数要求在按照非递减顺序排好序的数组中找到第一个大于给定值key的那个数索引，
     * 其基本实现原理是二分查找
     */
    public static int upperBound(int[] nums, int l, int r, int target) {
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] <= target) l = m + 1;
            else r = m;
        }
        return l;
    }
}
