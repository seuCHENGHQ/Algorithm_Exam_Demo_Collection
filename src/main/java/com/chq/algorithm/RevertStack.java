package com.chq.algorithm;

import java.util.Scanner;
import java.util.Stack;

public class RevertStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        for (int i = n - 1; i >= 0; i--) {
            stack.push(arr[i]);
        }
        revertStack(stack);
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        System.out.println(builder.toString());
    }

    public static void revertStack(Stack<Integer> stack) {
        if (stack == null || stack.size() == 0) {
            return;
        }
        Integer bottomElement = getBottomElement(stack);
        revertStack(stack);
        stack.push(bottomElement);
    }

    public static Integer getBottomElement(Stack<Integer> stack) {
        if (stack.isEmpty()) return null;
        if (stack.size() == 1) {
            return stack.pop();
        } else {
            Integer temp = stack.pop();
            Integer result = getBottomElement(stack);
            stack.push(temp);
            return result;
        }
    }
}
