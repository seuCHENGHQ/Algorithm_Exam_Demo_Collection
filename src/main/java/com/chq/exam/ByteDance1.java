package com.chq.exam;

import java.util.Arrays;
import java.util.Scanner;

public class ByteDance1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String temp = scan.nextLine();
        String[] tempArr = temp.split(" ");
        int n = Integer.parseInt(tempArr[0]);
        int m = Integer.parseInt(tempArr[1]);
        int q = Integer.parseInt(tempArr[2]);
        String str = scan.nextLine();
        System.out.println(str);
        for (int i = 0; i < q; i++) {
            int left = scan.nextInt();
            int right = scan.nextInt();
            System.out.println(str.substring(left - 1, right));
            System.out.println(score(str.substring(left - 1, right)));
        }
    }

    public static int score(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        //char[] arr = str.toCharArray();
        String[] strArr = str.split(" ");
        System.out.println(Arrays.toString(strArr));
        int[] score = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals("<") && strArr[i].equals(">")) {
                int val = Integer.parseInt(strArr[i]);
                score[i] = val;
            }
        }
        int result = 0;
        int index = 0;
        int direction = 1;//1 向右  0 向左
        while (true) {
            //走到了一个被摧毁的砖块上或者走出边界
            if (index < 0 || index >= strArr.length || score[index] == -1) {
                break;
            }
            if (strArr[index].equals("<")) {
                //首先判断是不是由'>'或者'<'过来的
                if (direction == 1) {
                    //从左边过来的
                    if (index - 1 >= 0) {
                        if (strArr[index - 1].equals("<") || strArr[index - 1].equals(">")) {
                            score[index] = -1;
                        }
                    }
                } else {
                    //从右边过来的
                    if (index + 1 < strArr.length) {
                        if (strArr[index + 1].equals("<") || strArr[index + 1].equals(">")) {
                            score[index] = -1;
                        }
                    }
                }
                direction = 0;
                --index;
            } else if (strArr[index].equals(">")) {
                //首先判断是不是由'>'或者'<'过来的
                if (direction == 1) {
                    //从左边过来的
                    if (index - 1 >= 0) {
                        if (strArr[index - 1].equals("<") || strArr[index - 1].equals(">")) {
                            score[index] = -1;
                        }
                    }
                } else {
                    //从右边过来的
                    if (index + 1 < strArr.length) {
                        if (strArr[index + 1].equals("<") || strArr[index + 1].equals(">")) {
                            score[index] = -1;
                        }
                    }
                }
                direction = 1;
                ++index;
            } else {
                result += score[index];
                --score[index];
                if (direction == 1) {
                    ++index;
                } else {
                    --index;
                }
            }
        }
        return result;
    }
}
