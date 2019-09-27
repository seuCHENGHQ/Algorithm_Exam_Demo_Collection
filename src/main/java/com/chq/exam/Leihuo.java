package com.chq.exam;

import java.math.BigDecimal;
import java.util.Scanner;

public class Leihuo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
//        int time = 0;
//        int maxLoad = 0;
        BigDecimal maxLoad = new BigDecimal(0);
        int prevTime = 0;
//        int load = 0;
        BigDecimal load = new BigDecimal(0);
        for (int i = 0; i < n; i++) {
            int currTime = arr[i][0];
            int currLoad = arr[i][1];
//            load = Math.max(0, load - (currTime - prevTime)) + currLoad;
            load = load.subtract(BigDecimal.valueOf(currTime - prevTime)).compareTo(BigDecimal.valueOf(0)) >= 0 ?
                    load.subtract(BigDecimal.valueOf(currTime - prevTime)).add(BigDecimal.valueOf(currLoad)) :
                    BigDecimal.valueOf(currLoad);
//            maxLoad = Math.max(load, maxLoad);
            maxLoad = load.compareTo(maxLoad) >= 0 ? load.multiply(BigDecimal.valueOf(1)) : maxLoad;
            prevTime = currTime;
        }
        BigDecimal time = load.add(BigDecimal.valueOf(prevTime));
//        time = prevTime + load;
        System.out.println(time.toString() + " " + maxLoad.toString());
    }

    public static int stoneGame(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int size = 1; size <= n; size++) {
            for (int i = 0; i + size < n; i++) {
                int j = i + size - 1;
                int round = (i + j + n) % 2;
                //如果round==1说明该先手拿了，如果round==0说明该后手拿了
                if (round == 1) {
                    dp[i][j] = Math.max(dp[i + 1][j] + arr[i], dp[i][j - 1] + arr[j - 1]);
                } else {
//                    dp[i][j] =
                }
            }
        }
        return -1;
    }
}
