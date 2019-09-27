package com.chq.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class ByteDance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        char[] arr = str.toCharArray();
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        list.add("");
        map.put(0, list);
        int val = Integer.parseInt(str.substring(0, 1));
        list = new ArrayList<>();
        list.add(String.valueOf((char) (val - 1 + 'A')));
        map.put(1, list);
        for (int i = 2; i <= str.length(); i++) {
            list = new ArrayList<>();
            int currVal = Integer.parseInt(str.substring(i - 1, i));
            System.out.println("currVal" + currVal);
            if (currVal == 0) {
                currVal = Integer.parseInt(str.substring(i - 2, i));
                String currStr = String.valueOf((char) (currVal - 1 + 'A'));
                for (String s : map.get(i - 2)) {
                    list.add(s + currStr);
                }
                map.put(i, list);
            } else {
                if (str.charAt(i - 1) == '0') {
                    String currStr = String.valueOf((char) (currVal - 1 + 'A'));
                    for (String s : map.get(i - 2)) {
                        list.add(s + currStr);
                    }
                } else {
                    String currStr = String.valueOf((char) (currVal - 1 + 'A'));
                    System.out.println("currStr" + currStr);
                    System.out.println(map.get(i - 1));
                    for (String s : map.get(i - 1)) {
                        list.add(s + currStr);
                    }
                    //i还可能和i-1组成一个字符
                    currVal = Integer.parseInt(str.substring(i - 2, i));
                    if (currVal >= 1 && currVal <= 26) {
                        currStr = String.valueOf((char) (currVal - 1 + 'A'));
                        for (String s : map.get(i - 2)) {
                            list.add(s + currStr);
                        }
                    }
                    map.put(i, list);
                }
            }
        }
        System.out.println(map);
        ArrayList<String> res = map.get(str.length());
        Collections.sort(res);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
