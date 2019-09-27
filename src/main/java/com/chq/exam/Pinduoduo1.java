package com.chq.exam;

import java.util.Arrays;
import java.util.Scanner;

public class Pinduoduo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner((System.in));
        String str = scan.nextLine();
        String[] arr = str.split(";");
        int N = Integer.parseInt(arr[1]);
        String[] numStrArr = arr[0].split(",");
        Integer[] numArr = new Integer[numStrArr.length];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(numStrArr[i]);
        }
        Arrays.sort(numArr, (Integer i1, Integer i2) -> {
            if (i1 % 2 == 0 && i2 % 2 == 0) {
                return i2 - i1;
            }
            if (i1 % 2 != 0 && i2 % 2 != 0) {
                return i2 - i1;
            }
            return i1 % 2 == 0 ? -1 : 1;
        });
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            builder.append(numArr[i]);
            builder.append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        System.out.println(builder.toString());
    }
}
