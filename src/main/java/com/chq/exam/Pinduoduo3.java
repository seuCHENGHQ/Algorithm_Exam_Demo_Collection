package com.chq.exam;

import java.util.Scanner;

public class Pinduoduo3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int[] arr = new int[len];
        int max = 1;
        double fenshu = 1.0;
        for (int i = 0; i < len; i++) {
            arr[i] = scan.nextInt();
            fenshu *= (1.0d / arr[i]);
            max = Math.max(max, arr[i]);
        }
        double result = 0.0;
        for (int i = 1; i <= max; i++) {
            int m = 0;
            int yinzi = 1;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] <= i) {
                    ++m;
                } else {
                    yinzi *= arr[j];
                }
            }
            int zuhe = 1;
            for (int j = 1; j <= m; j++) {
                zuhe += getCombination(j, m);
            }
            System.out.println("fenshu" + fenshu);
            System.out.println(zuhe);
            System.out.println(yinzi);
            System.out.println(i);
            System.out.println("--------");
            result += fenshu * zuhe * yinzi * i;
        }
        System.out.println(result);
    }

    public static int getFac(int i) {
        int result = 1;
        for (int j = 2; j <= i; j++) {
            result *= j;
        }
        return result;
    }

    public static int getCombination(int m, int n) {
        return getFac(n) / (getFac(m) * getFac(n - m));
    }
}
