package com.chq.exam;

public class Microsoft3 {
    public static void main(String[] args) {
        System.out.println(help("198", 0, 2
        ));
    }

    public static boolean help(String s, int i, int j) {

        if (j - i == 1 || i == j) {
            int num = Integer.valueOf(s.substring(i, j + 1));
            if (num % 2 == 0) {
                return true;
            } else {
                return false;
            }
        }
        if (s.charAt(i) == s.charAt(j)) {
            help(s, i + 1, j - 1);
        } else if ((int) s.charAt(i) - s.charAt(j) > 1 || (s.charAt(i) != 1 && s.charAt(j) > s.charAt(i))) {
            return false;
        } else if ((int) s.charAt(i) - s.charAt(j) == 1) {
            String s1 = "1";
            s += s.substring(i + 1, j);
            int num1 = Integer.valueOf(s.substring(j, j + 1));
            num1 -= 1;
            s1 += num1;

        } else {
            int num1 = Integer.valueOf(s.substring(i + 1, i + 2));
            num1 -= 1;
            String s1 = "";
            s1 += num1;
            if (s1.charAt(0) == s.charAt(j)) {
                String s2 = "";
                int num2 = Integer.valueOf(s.substring(i + 1, i + 2)) - Integer.valueOf(s.substring(j, j + 1));
                int num3 = Integer.valueOf(s.substring(j - 1, j)) - 1;
                s2 += num2;
                s2 += s.substring(i + 1, j - 1);
                s2 += num3;
                help(s2, 0, s2.length() - 1);
            } else {
                return false;
            }

        }
        return true;
    }
}
