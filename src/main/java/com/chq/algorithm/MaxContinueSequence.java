package com.chq.algorithm;

import java.util.Scanner;

public class MaxContinueSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();
        int[][] dp = new int[str1.length()][str2.length()];
        int len1 = str1.length();
        int len2 = str2.length();
        //先对dp数组边界上的元素进行初始化
        dp[0][0] = str1.charAt(0) == str2.charAt(0) ? 1 : 0;
        for (int i = 1; i < len1; i++) {
            dp[i][0] = str1.charAt(i) == str2.charAt(0) ? 1 : 0;
        }
        for (int j = 1; j < len2; j++) {
            dp[0][j] = str1.charAt(0) == str2.charAt(j) ? 1 : 0;
        }
        //得到完整的dp矩阵
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }

        //下面从右下角开始找出最长公共子串
        int maxLen = 0;
        int endStr1Index = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    endStr1Index = i;
                }
            }
        }
        if (maxLen == 0) {
            System.out.println(-1);
        } else {
            int startIndex = endStr1Index - maxLen + 1;
            System.out.println(str1.substring(startIndex, endStr1Index + 1));
        }
    }
}
