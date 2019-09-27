package com.chq.exam;

import java.util.Arrays;

public class Microsoft2 {
    public static void main(String[] args) {
        System.out.println(solution(31, 6));
    }

    public static int solution(int confidence, int primeNum) {
        int[] primeNumArr = getPrimeNumArr(primeNum);
        System.out.println(Arrays.toString(primeNumArr));
        int[][] dp = new int[primeNum][confidence + 1];
        for (int i = 0; i < primeNum; i++) {
            for (int j = 1; j <= confidence; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int j = 1; j <= confidence; j++) {
            if (j - primeNumArr[0] >= 0 && dp[0][j - primeNumArr[0]] != Integer.MAX_VALUE) {
                dp[0][j] = dp[0][j - primeNumArr[0]] + 1;
            }
        }
        for (int i = 1; i < primeNum; i++) {
            for (int j = 1; j <= confidence; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 1; (j - k * primeNumArr[i]) >= 0; k++) {
                    if (dp[i][j - k * primeNumArr[i]] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - k * primeNumArr[i]] + k);
                    }
                }
            }
        }
        if (dp[primeNum - 1][confidence] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[primeNum - 1][confidence];
    }

    public static int[] getPrimeNumArr(int num) {
        int[] arr = new int[num];
        arr[0] = 2;
        int index = 1;
        for (int curr = 3; index < num; curr++) {
            int root = (int) Math.sqrt(curr);
            boolean flag = true;
            for (int j = 2; j <= root; j++) {
                if (curr % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                arr[index++] = curr;
            }
        }
        return arr;
    }
}
