package com.chq.practice;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 快手笔试题
 * https://www.nowcoder.com/practice/b31734e46ba644de85a9cf95bbd57a5f?tpId=98&tqId=32840&tPage=1&rp=1&ru=%2Fta%2F2019test&qru=%2Fta%2F2019test%2Fquestion-ranking
 *
 * @author CHQ
 */
public class KuaiShou {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.nextLine();
        String s2 = scan.nextLine();
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        int[] pre = new int[arr1.length];
        int[] in = new int[arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            pre[i] = Integer.parseInt(arr1[i]);
            in[i] = Integer.parseInt(arr2[i]);
        }
        TreeNode root = generateTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        getChildSum(root);
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        StringBuilder builder = new StringBuilder();
        for (int i : list) {
            builder.append(i);
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        System.out.println(builder.toString());
    }

    public static TreeNode generateTree(int[] pre, int preLow, int preHigh,
                                        int[] in, int inLow, int inHigh) {
        if (preLow > preHigh) {
            return null;
        }
        if (preLow == preHigh) {
            return new TreeNode(pre[preLow]);
        }
        TreeNode root = new TreeNode(pre[preLow]);
        int index = inLow;
        for (; index <= inHigh; index++) {
            if (in[index] == root.val) {
                break;
            }
        }
        root.left = generateTree(pre, preLow + 1, preLow + index - inLow, in, inLow, index - 1);
        root.right = generateTree(pre, preLow + index - inLow + 1, preHigh, in, index + 1, inHigh);
        return root;
    }

    public static Result getChildSum(TreeNode root) {
        if (root == null) return new Result(0, 0);
        Result leftChild = getChildSum(root.left);
        Result rightChild = getChildSum(root.right);
        int currNodeVal = root.val;
        root.val = leftChild.childSum + leftChild.currNodeVal
                + rightChild.childSum + rightChild.currNodeVal;
        return new Result(root.val, currNodeVal);
    }

    public static void inOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}

class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
    }
}

class Result {
    public int childSum;
    public int currNodeVal;

    public Result(int sum, int val) {
        this.childSum = sum;
        this.currNodeVal = val;
    }
}