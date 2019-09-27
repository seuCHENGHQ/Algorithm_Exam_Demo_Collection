package com.chq.algorithm;

import java.util.Scanner;

public class MaxSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();
        int[][] dp = new int[str1.length()][str2.length()];
        //初始化
        dp[0][0] = str1.charAt(0)==str2.charAt(0)?1:0;
        for(int i=1;i<str1.length();i++){
            dp[i][0] = Math.max(dp[i-1][0],str1.charAt(i)==str2.charAt(0)?1:0);
        }
        for(int j=1;j<str2.length();j++){
            dp[0][j] = Math.max(dp[0][j-1],str2.charAt(j)==str1.charAt(0)?1:0);
        }

        //下面使用dp
        for(int i=1;i<str1.length();i++){
            for(int j=1;j<str2.length();j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if(str1.charAt(i)==str2.charAt(j)){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+1);
                }
            }
        }

        //下面进行逆推，找出一个公共子序列即可
        if(dp[str1.length()-1][str2.length()-1]==0){
            System.out.println(-1);
        }else{
            char[] arr = new char[dp[str1.length()-1][str2.length()-1]];
            int row = str1.length()-1;
            int col = str2.length()-1;
            int index = arr.length-1;
            while(index>=0){
                if(col>0&&dp[row][col]==dp[row][col-1]){
                    --col;
                }else if(row>0&&dp[row-1][col]==dp[row][col]){
                    --row;
                }else{
                    arr[index--] = str1.charAt(row);
                    --row;
                    --col;
                }
            }
            System.out.println(String.valueOf(arr));
        }
    }
}
