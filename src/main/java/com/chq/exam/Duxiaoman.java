package com.chq.exam;

import java.util.LinkedList;
import java.util.Scanner;

public class Duxiaoman {
    //    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int x = scan.nextInt();
//        int y = scan.nextInt();
//        int n = scan.nextInt();
//        int[][] barrier = new int[n][2];
//        int[][] flag = new int[1001][1001];
//        for (int i = 0; i < n; i++) {
//            barrier[i][0] = scan.nextInt();
//            barrier[i][1] = scan.nextInt();
//            int[] temp = map(barrier[i][0], barrier[i][1]);
//            flag[temp[0]][temp[1]] = -1;
//        }
//        ArrayList<ArrayList<int[]>> res = new ArrayList<>();
//        ArrayList<int[]> list = new ArrayList<>();
//        helper(0, 0, flag, x, y, res, list);
//        Collections.sort(res, (ArrayList<int[]> l1, ArrayList<int[]> l2) -> {
//            return l1.size() - l2.size();
//        });
//        System.out.println(res.get(0).size());
//    }
//
//    //这是DFS，不能这么干会StackOverFlow
//    public static void helper(int i, int j, int[][] flag, int endI, int endJ,
//                              ArrayList<ArrayList<int[]>> res, ArrayList<int[]> list) {
//        System.out.println(i + " " + j);
//        int[] coordinate = map(i, j);
//        int x = coordinate[0];
//        int y = coordinate[1];
//        int rows = flag.length;
//        int cols = flag[0].length;
//        if (x < 0 || x >= rows || y < 0 || y >= cols) {
//            return;
//        }
//        if (flag[x][y] == 1 || flag[x][y] == -1) {
//            return;
//        }
//        int[] temp = new int[2];
//        temp[0] = i;
//        temp[1] = j;
//        if (i == endI && j == endJ) {
//            list.add(temp);
//            ArrayList<int[]> tempList = new ArrayList<>();
//            for (int[] arr : list) {
//                temp = new int[2];
//                temp[0] = arr[0];
//                temp[1] = arr[1];
//                tempList.add(temp);
//            }
//            res.add(tempList);
//            list.remove(list.size() - 1);
//            return;
//        }
//        flag[x][y] = 1;
//        list.add(temp);
//        helper(i + 1, j, flag, x, y, res, list);
//        helper(i - 1, j, flag, x, y, res, list);
//        helper(i, j + 1, flag, x, y, res, list);
//        helper(i, j - 1, flag, x, y, res, list);
//        list.remove(list.size() - 1);
//    }
//
//    public static int[] map(int i, int j) {
//        int[] res = new int[2];
//        res[0] = i + 500;
//        res[1] = j + 500;
//        return res;
//    }
    private static final int MAX = 1005;
    private static final int BASE = 500;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean[][] visited = new boolean[MAX][MAX];
        int x = scanner.nextInt() + BASE;
        int y = scanner.nextInt() + BASE;
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int px = scanner.nextInt() + BASE;
            int py = scanner.nextInt() + BASE;
            visited[px][py] = true;
        }
        scanner.close();

        System.out.println(bfs(visited, x, y));
    }

    private static int bfs(boolean[][] visited, int ex, int ey) {
        //这里是为了产生上下左右4个点
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        visited[BASE][BASE] = true;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(BASE, BASE, 0));

        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();

            for (int[] dir : dirs) {
                int x = node.x + dir[0];
                int y = node.y + dir[1];

                if (x < 0 || x > MAX || y < 0 || y > MAX)
                    continue;

                //避免重复遍历地图中的点
                if (visited[x][y])
                    continue;

                //BFS第一次碰到就直接返回长度，不用继续下去了
                if (x == ex && y == ey)
                    return node.step + 1;

                //只要走过的就不会回到未走的状态，¬
                visited[x][y] = true;
                queue.add(new Node(x, y, node.step + 1));
            }
        }

        return -1;
    }
}

class Node {
    public int x;
    public int y;
    public int step;

    public Node(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}
