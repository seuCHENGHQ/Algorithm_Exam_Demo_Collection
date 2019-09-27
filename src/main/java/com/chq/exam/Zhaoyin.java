package com.chq.exam;

import java.util.HashSet;

public class Zhaoyin {
    public static void main(String[] args) {
        System.out.println(cal(12));
    }

    public static int cal(int n) {
        char[] arr = new char[n];
        HashSet<String> set = new HashSet<>();
        set(arr, 0, set);
        return set.size();
    }

    public static void set(char[] arr, int index, HashSet<String> set) {
        if (index == arr.length) {
            if (valid(arr)) {
                set.add(String.valueOf(arr));
            }
            return;
        }
        arr[index] = 'A';
        set(arr, index + 1, set);
        arr[index] = 'B';
        set(arr, index + 1, set);
        arr[index] = 'C';
        set(arr, index + 1, set);
    }

    public static boolean valid(char[] arr) {
        int continueB = 0;
        int maxContinueB = 0;
        int countC = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'C') {
                ++countC;
            } else if (arr[i] == 'B') {
                if (i > 0) {
                    if (arr[i - 1] == 'B') {
                        ++continueB;
                    } else {
                        continueB = 1;
                    }
                } else {
                    ++continueB;
                }
                maxContinueB = Math.max(continueB, maxContinueB);
            }
        }
        if (maxContinueB > 2 || countC > 1) {
            return false;
        }
        return true;
    }
}
