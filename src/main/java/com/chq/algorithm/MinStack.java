package com.chq.algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        for (int i = 0; i < n; i++) {
            String operation = scan.next();
            if (operation.equals("peek")) {
                if (s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                        Integer temp = s1.pop();
                        s2.push(temp);
                    }
                    System.out.println(s2.peek());
                } else {
                    System.out.println(s2.peek());
                }
            } else if (operation.equals("poll")) {
                if (s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                        Integer temp = s1.pop();
                        s2.push(temp);
                    }
                    System.out.println(s2.peek());
                } else {
                    System.out.println(s2.pop());
                }
            } else {
                Integer num = Integer.parseInt(scan.next());
                s1.push(num);
            }
        }
    }


}
