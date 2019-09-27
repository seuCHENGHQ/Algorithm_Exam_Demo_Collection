package com.chq.exam;

import java.util.ArrayList;
import java.util.List;

/**
 * 笔试第二题，多约束01背包问题
 *
 * @author chenghq
 */
public class Vivo {

    public static void main(String[] args) {
        List<Service> services = new ArrayList<>();
        services.add(new Service(5, 1, 1000));
        services.add(new Service(2, 3, 3000));
        services.add(new Service(5, 2, 15000));
        services.add(new Service(10, 4, 16000));
        System.out.println(solution(15, 10, services));
    }

    public static int solution(int totalMem, int totalDisk, List<Service> services) {
        int[][][] dp = new int[services.size()][totalDisk + 1][totalMem + 1];
        //首先对第一个service进行初始化
        for (int j = 0; j <= totalDisk; j++) {
            for (int k = 0; k <= totalMem; k++) {
                if (services.get(0).getDisk() <= totalDisk &&
                        services.get(0).getMem() <= totalMem) {
                    dp[0][j][k] = services.get(0).getUser();
                }
            }
        }
        for (int i = 1; i < services.size(); i++) {
            for (int j = 0; j <= totalDisk; j++) {
                for (int k = 0; k <= totalMem; k++) {
                    if (services.get(i).getDisk() <= j &&
                            services.get(i).getMem() <= k) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k],
                                dp[i][j - services.get(i).getDisk()][k - services.get(i).getMem()] + services.get(i).getUser());
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[services.size() - 1][totalDisk][totalMem];
    }

    static class Service {
        private int disk;
        private int mem;
        private int user;

        public Service(int disk, int mem, int user) {
            this.disk = disk;
            this.mem = mem;
            this.user = user;
        }

        public int getDisk() {
            return disk;
        }

        public void setDisk(int disk) {
            this.disk = disk;
        }

        public int getMem() {
            return mem;
        }

        public void setMem(int mem) {
            this.mem = mem;
        }

        public int getUser() {
            return user;
        }

        public void setUser(int user) {
            this.user = user;
        }
    }
}
