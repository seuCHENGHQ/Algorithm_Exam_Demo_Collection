package com.chq.algorithm;

import java.util.Scanner;

public class FindTargetNumberInRotateOrderedArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int target = scan.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scan.nextInt();
        }
        int low = 0;
        int high = len - 1;
        while (high - low > 1) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                high = mid;
                break;
            } else if (arr[mid] > target) {
                if (arr[mid] > arr[low]) {
                    high = mid;
                } else {
                    low = mid;
                }
            } else {
                if (arr[mid] > arr[low]) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
        }
        if (arr[low] == target || arr[high] == target) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
