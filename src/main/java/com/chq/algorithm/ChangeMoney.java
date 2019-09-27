package com.chq.algorithm;

import java.util.Scanner;

public class ChangeMoney {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int aim = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        /*
         *   dp[i][j] 用第0～i面值的货币，组成j元钱，最少需要用几张货币
         */
        int[][] dp = new int[n][aim + 1];
        int max = Integer.MAX_VALUE;
        //对只使用第1个面值第货币时第情况进行初始化
        for (int j = 1; j <= aim; j++) {
            dp[0][j] = max;
            //若当前要组成的价格j可以由第一种面值的货币直接组成，那么就直接设置对应的值
            if ((j - arr[0] >= 0) && (dp[0][j - arr[0]] != max)) {
                dp[0][j] = dp[0][j - arr[0]] + 1;
            }
        }
        //第一行不用初始化，是因为如果你要组成总价是0，那么不论有多少种面值的货币，组成方法总是0
        int indicator = max;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                indicator = max;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
                    indicator = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(indicator, dp[i - 1][j]);
            }
        }
        int result = dp[n - 1][aim] == max ? -1 : dp[n - 1][aim];
        System.out.println(result);
    }
}
