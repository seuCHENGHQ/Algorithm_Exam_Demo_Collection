package com.chq.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 快手笔试题：搭积木，使用二分还是超时
 * https://www.nowcoder.com/practice/55371b74b2f243e3820e57ee4c7b5504?tpId=98&tqId=32841&tPage=1&rp=1&ru=%2Fta%2F2019test&qru=%2Fta%2F2019test%2Fquestion-ranking
 *
 * @author CHQ
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int[][] wood = new int[len][2];
        for (int i = 0; i < len; i++) {
            //宽
            wood[i][0] = scan.nextInt();
            //长
            wood[i][1] = scan.nextInt();
        }
        Arrays.sort(wood, (int[] arr1, int[] arr2) -> {
            if (arr1[0] == arr2[0]) {
                //当宽度相同时，将长度按照从小到大排序
                return arr1[1] - arr2[1];
            } else {
                return arr1[0] - arr2[0];
            }
        });
        int count = 0;
        int[] dp = new int[len];
        //下面找长度的最长递增子序列即可,使用下边这种方法时间复杂度是O(n^2)
        /*
        for(int i=0;i<len;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(wood[i][1]>=wood[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            count = Math.max(dp[i],count);
        }
        */
        //利用二分的思想，将复杂度降到O(NlogN)
        int[] end = new int[len];
        dp[0] = 1;
        count = 1;
        end[0] = wood[0][1];
        int right = 0;
        for (int i = 1; i < len; i++) {
            int l = 0;
            int r = right;
            //利用二分找到小于等于arr[i]的end数组对应的位置
            while (l <= r) {
                int m = (l + r) / 2;
                if (end[m] <= wood[i][1]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            end[l] = wood[i][1];
            dp[i] = l + 1;
            count = Math.max(dp[i], count);
        }
        System.out.println(count);
    }

    //dp，复杂度为O(N^2)的方法

    //dp，复杂度为O(NlogN)的方法，额外使用了二分的思想


}
