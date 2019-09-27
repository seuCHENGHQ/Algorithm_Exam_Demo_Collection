package com.chq.practice;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 牛客网 a/b算法题
 * 重点在于除法不能产生无限不循环小数，因此可以放心的去进行while循环
 *
 * @author chenghq
 */
public class DivisionSimulation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        if (a % b == 0) {
            System.out.println(a / b);
            return;
        }
        StringBuilder res = new StringBuilder();
        res.append(a / b).append('.');
        StringBuilder decimal = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        while (a != 0) {
            a = a % b * 10;
            if (map.containsKey(a)) {
                String all = decimal.toString();
                int startIndex = map.get(a);
                res.append(all.substring(0, startIndex));
                res.append("(").
                        append(all.substring(startIndex)).
                        append(")");
                System.out.println(res.toString());
                return;
            }
            decimal.append(a / b);
            map.put(a, index++);
        }
    }
}
