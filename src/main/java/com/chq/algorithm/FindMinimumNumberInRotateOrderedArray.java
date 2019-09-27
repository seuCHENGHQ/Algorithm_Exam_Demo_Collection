package com.chq.algorithm;

import java.util.Scanner;

public class FindMinimumNumberInRotateOrderedArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scan.nextInt();
        }
        int low = 0;
        int high = len - 1;
        int mid = 0;
        while (high - low > 1) {
            mid = (low + high) / 2;
            if (arr[mid] > arr[low]) {
                high = mid;
            } else {
                low = mid;
            }
        }
        System.out.println(Math.min(arr[low], arr[high]));
    }
}
