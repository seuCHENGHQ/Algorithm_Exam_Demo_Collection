package com.chq.designModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.nextLine();
        String s2 = scan.nextLine();
        System.out.println(Arrays.toString(s1.split(" ")));
        System.out.println(s2);
    }
}
