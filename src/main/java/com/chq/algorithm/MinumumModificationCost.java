package com.chq.algorithm;

public class MinumumModificationCost {
    public static void main(String[] args) {
        System.out.println(minMidificationCost("abc", "adc", 5, 3, 100));
    }

    public static int minMidificationCost(String str1, String str2, int ic, int dc, int rc) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        //0~row的str1字串编辑到str2==""时所需要消耗的代价，只有删除操作
        for (int row = 1; row <= str1.length(); row++) {
            dp[row][0] = dc * row;
        }
        //str1==""时，编辑到0~col的str2字串所需要消耗的代价，只有增加操作
        for (int col = 1; col <= str2.length(); col++) {
            dp[0][col] = ic * col;
        }
        //这里正式进入dp的步骤，0~row的str1子串编辑到0~col的str2子串所需要消耗的最小代价
        for (int row = 1; row <= str1.length(); row++) {
            for (int col = 1; col <= str2.length(); col++) {
                int cost = Math.min(dp[row - 1][col] + dc, dp[row][col - 1] + ic);
                if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                    dp[row][col] = Math.min(dp[row - 1][col - 1], cost);
                } else {
                    dp[row][col] = Math.min(dp[row - 1][col - 1] + rc, cost);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
