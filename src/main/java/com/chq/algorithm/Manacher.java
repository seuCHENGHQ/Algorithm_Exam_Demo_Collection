package com.chq.algorithm;

import java.util.Arrays;

/**
 * 马拉车算法，用于以O(N)的时间复杂度求得字符串的最长回文子串
 * 最长回文子串和最长回文子序列的dp解法
 *
 * @author chenghq
 * @version 1.0
 */
public class Manacher {
    public static void main(String[] args) {
        String str = "abacabd";
        System.out.println(Arrays.toString(manacherString(str)));
        System.out.println(manacher(str));
        System.out.println(getLPSByDp(str));
        str = "abca";
        System.out.println(getLPSByDP(str));
    }

    public static char[] manacherString(String str) {
        char[] arr = str.toCharArray();
        char[] res = new char[2 * arr.length + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            res[index++] = '#';
            res[index++] = arr[i];
        }
        res[index++] = '#';
        return res;
    }

    public static int manacher(String str) {
        char[] arr = manacherString(str);
        int[] pArr = new int[arr.length];
        int rightBound = -1;
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            //当i=0的时候，index=-1，2*index-0=-1，但是此时不会走这个pArr的逻辑的
            pArr[i] = rightBound > i ? Math.min(pArr[2 * index - i], rightBound - i) : 1;
            //为了防止没有得到以i为中心的回文串，还需要继续向两边扩展，直到
            while (i + pArr[i] < arr.length && i - pArr[i] > -1) {
                if (arr[i + pArr[i]] == arr[i - pArr[i]]) {
                    ++pArr[i];
                } else {
                    break;
                }
            }

            //判断是否需要更新index和rightBound
            if (i + pArr[i] > rightBound) {
                rightBound = i + pArr[i];
                index = i;
            }

            //更新最长回文子串长度
            max = Math.max(max, pArr[i]);
        }

        //为什么需要-1呢？
        return max - 1;
    }


    /**
     * 还可以通过dp来求解最长回文子串的问题
     * 如果需要输出最长回文子串的话，除了维护长度，还要维护一个开始索引start
     */
    public static int getLPSByDp(String str) {
        char[] charArr = str.toCharArray();
        boolean[][] arr = new boolean[str.length()][str.length()];
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            arr[i][i] = true;
            max = 1;
        }

        //要特别注意这里的顺序，要逐渐移动j才能判断出正确的结果，j是以第j个字符结尾
        for (int j = 1; j < str.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (j - i < 2) {
                    arr[i][j] = charArr[i] == charArr[j];
                } else {
                    arr[i][j] = arr[i + 1][j - 1] && (charArr[i] == charArr[j]);
                    if (arr[i][j] && j - i + 1 > max) {
                        max = j - i + 1;
                    }
                }
            }
        }
        return max;
    }

    /**
     * 通过dp求解最长回文子序列的问题
     * 子序列最大的特点就是不要求连续，因此无需一个boolean矩阵来表示i~j的子串是否是回文串
     */
    public static int getLPSByDP(String str) {
        char[] arr = str.toCharArray();
        int[][] dp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i][i] = 1;
        }
        int max = 1;
        for (int j = 1; j < arr.length; j++) {
            for (int i = 0; i < j; i++) {
                if (arr[i] == arr[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
