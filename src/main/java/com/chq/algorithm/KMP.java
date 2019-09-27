package com.chq.algorithm;

/**
 * KMP算法以O(N)的时间复杂度来匹配出m是不是s中的一个字串
 *
 * @author CHQ
 */
public class KMP {
    public static void main(String[] args) {
        System.out.println(getIndex("abcdef", "dd"));
    }

    public static int getIndex(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int si = 0;
        int mi = 0;
        for (int i = 0; i < s.length(); ) {
            if (ss[i] == ms[0]) {
                int index = 0;
                while (i + index < ss.length && index < ms.length && ss[i + index] == ms[index]) {
                    ++index;
                }
                if (index == ms.length) {
                    return i;
                } else {
                    i = i + index;
                }
            } else {
                ++i;
            }
        }
        return -1;
    }
}
