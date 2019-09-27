package com.chq.exam;

import java.util.Stack;

public class ByteDance2 {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 3, 4, 8};
        System.out.println(solution(arr));
        arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int count = 0;
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
                ++count;
            }
            stack.push(arr[i]);
            res = Math.max(res, count);
        }
        return res;
    }
}
