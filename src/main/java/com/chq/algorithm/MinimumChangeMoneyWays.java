package com.chq.algorithm;

import java.util.Scanner;

/**
 * @author chenghq
 * 和换钱的方法数不同的地方在于，这里需要计算的是最少需要几张货币能把target换开
 * https://www.nowcoder.com/practice/4e05294fc5aa4d4fa8eacef2e606e5a8?tpId=101&tqId=33080&tPage=1&rp=1&ru=%2Fta%2Fprogrammer-code-interview-guide&qru=%2Fta%2Fprogrammer-code-interview-guide%2Fquestion-ranking
 */
public class MinimumChangeMoneyWays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int target = scan.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scan.nextInt();
        }
        int[][] dp = new int[len][target + 1];
        int max = Integer.MAX_VALUE;
        //这里对只用index=0面值的货币换钱时的情况进行初始化，因为换0元的时候，最少用0张货币能换开，因此无需初始化
        for (int j = 1; j < target + 1; j++) {
            dp[0][j] = max;
            if (j - arr[0] >= 0 && dp[0][j - arr[0]] != max) {
                dp[0][j] = dp[0][j - arr[0]] + 1;
            }
        }

        //下面对dp矩阵剩下的元素进行计算
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= target; j++) {
                int indicator = max;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
                    indicator = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(indicator, dp[i - 1][j]);
            }
        }
        int result = dp[len - 1][target] == max ? -1 : dp[len - 1][target];
        System.out.println(result);
    }
}
