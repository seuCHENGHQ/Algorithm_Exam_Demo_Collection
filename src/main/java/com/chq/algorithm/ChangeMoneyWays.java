package com.chq.algorithm;

import java.util.Scanner;

/**
 * @author chenghq
 * 换钱的方法数
 * 牛客网
 * https://www.nowcoder.com/practice/39cb6c6e2b844a8cba382c8e26951e0a?tpId=101&tqId=33087&tPage=1&rp=1&ru=/ta/programmer-code-interview-guide&qru=/ta/programmer-code-interview-guide/question-ranking
 */
public class ChangeMoneyWays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int target = scan.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scan.nextInt();
        }
        int[][] dp = new int[len][target + 1];
        //当需要组成0元时，只有一种换钱方法，也就是一张面值的都不用
        for (int row = 0; row < len; row++) {
            dp[row][0] = 1;
        }

        //当只用第0个面值的货币时，对其能够组成的面值进行初始化
        for (int j = 1; j * arr[0] < target + 1; j++) {
            dp[0][j * arr[0]] = 1;
        }
        //下面就是完全背包问题
        int temp = (int) 1e9 + 7;
        for (int row = 1; row < len; row++) {
            for (int col = 1; col < target + 1; col++) {
                int num = 0;
                //当第row面值的货币使用j次时，有几种换钱方法，要叠加起来
                for (int k = 0; col - arr[row] * k >= 0; k++) {
                    num += dp[row - 1][col - arr[row] * k];
                    num = num % temp;
                }
                dp[row][col] = num;
            }
        }
        System.out.println(dp[len - 1][target]);
    }
}
