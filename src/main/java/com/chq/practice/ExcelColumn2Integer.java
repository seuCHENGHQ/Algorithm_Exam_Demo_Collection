package com.chq.practice;

public class ExcelColumn2Integer {
    public static void main(String[] args) {
        System.out.println(transfer("AC"));
        System.out.println(reverseTrans(28));
    }

    public static Integer transfer(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }

        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum = (str.charAt(i) - 'A' + 1) + sum * 26;
        }
        return sum;
    }

    public static String reverseTrans(int i) {
        if (i <= 0) {
            return "";
        }

        String res = "";
        while (i > 0) {
            res = ((char) (i % 26 - 1 + 'A')) + res;
            i /= 26;
        }
        return res;
    }
}
