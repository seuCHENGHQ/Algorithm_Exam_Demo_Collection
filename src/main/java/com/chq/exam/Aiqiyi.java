package com.chq.exam;

public class Aiqiyi {
    private static double result = 0.0;
    private static double[] arr = {0.0};

    public static void main(String[] args) {
        calculate(3, 4, 1.0, arr);
        System.out.println(result);
    }

    public static void calculate(int red, int blue, double temp, double[] array) {
        if (red < 0 || blue < 0 || red + blue == 0) return;
        result = result + temp * red / (red + blue);
        System.out.println(result);
        System.out.println("-------------------");
//        System.out.println(temp);
        if (blue >= 2) {
            temp = temp * blue / (red + blue);
            blue--;
            temp = temp * blue / (red + blue);
            blue--;
            if (blue >= 1) {
                calculate(red, blue - 1, temp * blue / (red + blue), arr);
            }
            if (red >= 1) {
                calculate(red - 1, blue, temp * red / (red + blue), arr);
            }
        }
    }

    public static double cal(int red, int blue){
        //如果没有红球，B胜利
        if(red<=0){
            return 0.0;
        }
        //如果没有蓝球，B直接胜利
        if(blue<=0){
            return 1.0;
        }
        double res = 0.0;
        //A抓红球的概率
        double aRed = (red/(red+blue));
        //A抓走一个蓝球
        --blue;
        if(blue==0){
            return aRed;	//如果蓝球没了，B下一个抓，一定B赢
        }

        //B抓蓝球的概率
        double bBlue = (blue/(red+blue));
        //B也抓走了蓝球
        --blue;
        double cRed = (red/(red+blue));
        double cBlue = (blue/(red+blue));
        res = aRed + aRed*bBlue*(cRed*cal(red-1,blue)+cBlue*cal(red,blue-1));
        return res;
    }
}
