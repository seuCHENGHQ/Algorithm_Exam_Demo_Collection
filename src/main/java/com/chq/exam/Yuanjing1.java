package com.chq.exam;

public class Yuanjing1 {
    public static void main(String[] args) {
        int[] arr = new int[]{100, 180, 310, 535, 695};
        System.out.println(maxLoss(arr));
        arr = new int[]{100, 180, 0, 310, 40, 535, 695};
        System.out.println(maxLoss(arr));
    }

    public static int maxLoss(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < arr.length; ) {
            if (i + 1 < arr.length && arr[i + 1] < arr[i]) {
                int left = i;
                while (i + 1 < arr.length && arr[i + 1] < arr[i]) {
                    ++i;
                }
                res += arr[left] - arr[i];
            }
            ++i;
        }
        return res;
    }

    public static int maxLoss(int[] arr, int left) {
        if (arr.length <= left) {
            return 0;
        }
        int max = 0;
//        for()
        return max;
    }
}
