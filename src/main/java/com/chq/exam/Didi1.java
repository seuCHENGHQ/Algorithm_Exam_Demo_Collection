package com.chq.exam;

public class Didi1 {
    public static void main(String[] args) {
        System.out.println(solution("sysysytm", 3));
    }

    public static String solution(String str, int k) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] arr = new char[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = '0';
        }
        for (int i = 0; i < str.length(); i++) {
            for (int a = 0; a * (k + 1) < i + 1; a++) {
                if (((i + 1 - a * (k + 1)) % k) != 0) {
                    continue;
                }
                if (valid(str, a, (i + 1 - a * (k + 1)) / k, k)) {
                    arr[i] = '1';
                    break;
                }
            }
        }
        return String.valueOf(arr);
    }

    public static boolean valid(String str, int lenA, int lenB, int k) {
        String a = str.substring(0, lenA);
        String b = str.substring(lenA, lenA + lenB);
        for (int i = 1; i < k; i++) {
            System.out.println("i=" + i);
            String nextA = str.substring(i * (lenA + lenB), (i + 1) * lenA + i * lenB);
            String nextB = str.substring((i + 1) * lenA + i * lenB, (i + 1) * (lenA + lenB));
            if (!a.equals(nextA) || !b.equals(nextB)) {
                return false;
            }
        }
        String nextA = str.substring(k * (lenA + lenB), (k + 1) * lenA + k * lenB);
        if (!a.equals(nextA)) {
            return false;
        }
        return true;
    }
}
