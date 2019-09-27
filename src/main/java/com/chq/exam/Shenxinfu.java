package com.chq.exam;

import java.util.ArrayList;

public class Shenxinfu {
    private static int res = Integer.MIN_VALUE;
    private static int res1 = Integer.MIN_VALUE;

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[][] arr = new int[][]{
                {10, 1, 1, 1, 1},
                {10, 1, 1, 1, 1},
                {10, 1, 1, 1, 1},
                {1, 10, 1, 1, 1},
                {10, 1, 1, 1, 1},
                {10, 1, 1, 1, 1},
                {1, 1, 1, 10, 1},
                {1, 10, 1, 1, 1},
                {1, 1, 10, 1, 1},
                {10, 1, 1, 1, 1},
                {10, 1, 1, 1, 1}
        };
//        int[][] arr = new int[][]{{10, 1, 1, 1, 1},
//                {1, 10, 1, 1, 1},
//                {1, 1, 10, 1, 1},
//                {1, 1, 1, 10, 1},
//                {10, 1, 1, 1, 1},
//                {1, 10, 1, 1, 1},
//                {1, 1, 10, 1, 1},
//                {1, 1, 1, 10, 1}};
        solution(arr, 0, list, 0);
        System.out.println(res1);
        System.out.println("==============================");

        list.clear();
        solution1(arr, 0, list, 0);
        System.out.println(res);
        System.out.println(Integer.MIN_VALUE);
    }

    public static void solution(int[][] arr, int day, ArrayList<Integer> list, int temp) {
        if (day == arr.length) {
            res1 = Math.max(res1, temp);
            return;
        }

        list.add(4);
        solution(arr, day + 1, list, temp + arr[day][4]);
        list.remove(list.size() - 1);
        for (int j = 0; j < 4; j++) {
            if (day == 0 || (list.get(day - 1) == 4) || (day == 1 && list.get(day - 1) != j) || (day >= 2 && list.get(day - 2) != j && list.get(day - 1) != j)) {
                list.add(j);
                solution(arr, day + 1, list, temp + arr[day][j]);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void solution1(int[][] arr, int day, ArrayList<Integer> list, int temp) {
        if (day == arr.length) {
            res = Math.max(res, temp);
            return;
        }
        if (day == 0) {
            for (int j = 0; j < 5; j++) {
//                temp += arr[0][j];
                list.add(j);
                solution(arr, day + 1, list, temp + arr[day][j]);
//                temp -= arr[0][j];
                list.remove(list.size() - 1);
            }
        } else if (day == 1) {
            int yesterdayRest = list.get(0);
            if (yesterdayRest == 4) {
                //如果昨天去的是5号餐厅，那么今天哪家都能去
                for (int j = 0; j < 5; j++) {
//                    temp += arr[0][j];
                    list.add(j);
                    solution(arr, day + 1, list, temp + arr[day][j]);
//                    temp -= arr[0][j];
                    list.remove(list.size() - 1);
                }
            } else {
                //如果昨天去的不是5号餐厅，那么今天不能去昨天那一家
                for (int j = 0; j < 5; j++) {
                    if (j == yesterdayRest) {
                        continue;
                    }
//                    temp += arr[0][j];
                    list.add(j);
                    solution(arr, day + 1, list, temp + arr[day][j]);
//                    temp -= arr[0][j];
                    list.remove(list.size() - 1);
                }
            }
        } else {
            int yesterdayRest = list.get(day - 1);
            int dayBeforeYesterdayRest = list.get(day - 2);
            if (yesterdayRest == 4) {
                //如果昨天去了5食堂
                for (int j = 0; j < 5; j++) {
//                    temp += arr[0][j];
                    list.add(j);
                    solution(arr, day + 1, list, temp + arr[day][j]);
//                    temp -= arr[0][j];
                    list.remove(list.size() - 1);
                }
            } else {
                //如果昨天去的不是5食堂
                for (int j = 0; j < 5; j++) {
                    if (j == yesterdayRest) {
                        continue;
                    }
                    if (j == dayBeforeYesterdayRest && dayBeforeYesterdayRest != 4) {
                        continue;
                    }
//                    temp += arr[0][j];
                    list.add(j);
                    solution(arr, day + 1, list, temp + arr[day][j]);
//                    temp -= arr[0][j];
                    list.remove(list.size() - 1);
                }
            }
        }
    }

}
