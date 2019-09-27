package com.chq.practice;

import java.util.Scanner;

public class StringContain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            String str1 = scan.next();
            String str2 = scan.next();
            if (str2.length() > str1.length()) {
                String temp = str1;
                str1 = str2;
                str2 = temp;
            }
            boolean flag = false;
            for (int i = 0; i < str1.length(); ) {
                if (str1.charAt(i) == str2.charAt(0)) {
                    int index = 0;
                    while ((i + index < str1.length()) &&
                            (index < str2.length()) &&
                            (str1.charAt(i + index) == str2.charAt(index))) {
                        ++index;
                    }
                    if (index == str2.length()) {
                        flag = true;
                        break;
                    } else {
                        i = index + i;
                    }
                } else {
                    ++i;
                }
            }
            if (flag) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
