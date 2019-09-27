package com.chq.exam;

import java.util.Scanner;

public class Ctrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        int[][] arr = new int[rows][cols];
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        int p = scan.nextInt();
        int q = scan.nextInt();
        dp[0][p] = arr[0][p];
        int res1 = dp[0][p];
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val1 = j - 1 >= 0 ? dp[i - 1][j - 1] + arr[i][j] : 0;
                int val2 = dp[i - 1][j] + arr[i][j];
                int val3 = j + 1 < cols ? dp[i - 1][j + 1] + arr[i][j] : 0;
                dp[i][j] = Math.max(val1, val2);
                dp[i][j] = Math.max(dp[i][j], val3);
                res1 = Math.max(dp[i][j], res1);
            }
        }

        dp = new int[rows][cols];
        dp[rows - 1][q] = arr[rows - 1][q];
        int res2 = dp[rows - 1][q];
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                int val1 = j - 1 >= 0 ? dp[i + 1][j - 1] + arr[i][j] : 0;
                int val2 = dp[i + 1][j] + arr[i][j];
                int val3 = j + 1 < cols ? dp[i + 1][j + 1] + arr[i][j] : 0;
                dp[i][j] = Math.max(val1, val2);
                dp[i][j] = Math.max(dp[i][j], val3);
                res2 = Math.max(res2, dp[i][j]);
            }
        }
        System.out.println(Math.max(res1, res2));
    }
}
