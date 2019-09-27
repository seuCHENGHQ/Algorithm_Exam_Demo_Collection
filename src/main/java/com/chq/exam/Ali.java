package com.chq.exam;

import java.util.*;
import java.util.concurrent.Executors;

public class Ali {
    static String getIndexAndLongest(String users, int k) {
        int happyBoy = -1;
        int count = Integer.MIN_VALUE;
        //先找到最幸福男生
        char[] arr = users.toCharArray();
        for (int i = 0; i < users.length(); ) {
            if (arr[i] == 'b') {
                int left = i - 1;
                int right = i + 1;
                while (left >= 0 && arr[left] == 'g') {
                    --left;
                }
                while (right < users.length() && arr[right] == 'g') {
                    ++right;
                }
                int girls = (i - left - 1) + (right - i - 1);
                if (girls > count) {
                    count = girls;
                    happyBoy = i;
                }
                i = right;
            } else {
                ++i;
            }
        }

        //使用双指针来查找男生最多的团体
        int left = 0;
        int boyCount = arr[0] == 'b' ? 1 : 0;
        int girlCount = arr[0] == 'g' ? 1 : 0;
        int result = 0;
        boolean flag = false;
        for (int i = 1; i < users.length(); ) {
            if (arr[i] == 'g') {
                ++girlCount;
                if (girlCount > k) {
                    while (left < users.length() && left <= i && arr[left] == 'b') {
                        ++left;
                        --boyCount;
                    }
                    if (left == users.length()) {
                        left = 0;
                        while (left < users.length() && left <= i && arr[left] == 'b') {
                            ++left;
                            --boyCount;
                        }
                    }
                    ++left;
                    --girlCount;
                }
            } else {
                ++boyCount;
            }
            if (boyCount > result) {
                result = boyCount;
            }
            ++i;
            if (i == users.length()) {
                i = 0;
                flag = true;
            }
            if (flag && i == users.length()) {
                break;
            }
        }
        if (boyCount > result) {
            result = boyCount;
        }

        return String.valueOf(happyBoy + " " + result);
        //

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _users;
        int k = 0;
        try {
            _users = in.nextLine();
            k = in.nextInt();
        } catch (Exception e) {
            _users = null;
        }

        res = getIndexAndLongest(_users, k);
        System.out.println(res);
        System.out.println(k);

        Executors.newFixedThreadPool(10);
        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(10);
    }
}
