package com.chq.exam;

import java.util.ArrayList;

public class Xinlang {
    public static void main(String[] args) {
        String[] list = new String[]{"3", "4.3.5.4", "2.10.3", "2.4"};
        System.out.println(getMinVersion(list));
    }

    public static String getMinVersion(String[] list) {
        String[] verArr = list;
        //找到最大长度
        int maxLen = 0;
        for (int i = 0; i < verArr.length; i++) {
            int temp = verArr[i].split("\\.").length;
            if (temp > maxLen) {
                maxLen = temp;
            }
        }
        //在不足最大长度的版本号后边补上.0
        for (int i = 0; i < verArr.length; i++) {
            String str = verArr[i];
            int currLen = verArr[i].split("\\.").length;
            int remain = maxLen - currLen;
            for (int j = remain; j > 0; j--) {
                str += ".0";
            }
            verArr[i] = str;
        }
        //然后下面对index位置的数字进行排序，取出最小值的部分
        int index = 0;
//        List<String> verList = Arrays.asList(verArr);
        ArrayList<String> verList = new ArrayList<>();
        for (int i = 0; i < verArr.length; i++) {
            verList.add(verArr[i]);
        }
        while (verList.size() > 1) {
            int minVal = Integer.MAX_VALUE;
            for (int i = 0; i < verList.size(); i++) {
                int currVal = Integer.parseInt(verList.get(i).split("\\.")[index]);
                if (currVal < minVal) {
                    minVal = currVal;
                }
            }
            //删除对应index不为最小值的版本号
            for (int i = 0; i < verList.size(); i++) {
                int currVal = Integer.parseInt(verList.get(i).split("\\.")[index]);
                if (currVal != minVal) {
                    verList.remove(i);
                    --i;
                }
            }
            ++index;
        }
        String res = verList.get(0);
        //移除末尾的.0即可
        res = res.replaceAll("\\.0", "");
        return res;


//        String res = "";
//        int temp = Integer.MAX_VALUE;
//        for (int i = 0; i < verArr.length; i++) {
//            int currVal = 0;
//            String[] arr = verArr[i].split("\\.");
//            int currLen = arr.length;
//            int tenCount = maxLen - currLen;
//            for (int j = 0; j < arr.length; j++) {
//                currVal = currVal * 10 + Integer.parseInt(arr[j]);
//            }
//            for (int j = tenCount; j > 0; j--) {
//                currVal *= 10;
//            }
//            if (currVal < temp) {
//                temp = currVal;
//                res = verArr[i];
//            }
//        }
//        return res;
    }
}
