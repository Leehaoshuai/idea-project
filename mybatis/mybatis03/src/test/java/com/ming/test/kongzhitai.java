package com.ming.test;

import java.util.Scanner;

public class kongzhitai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入第一个数");
        int first = scanner.nextInt();
        System.out.println("输入第二个数");
        int second = scanner.nextInt();
        System.out.println("输入符号");
        String fuhao = scanner.next();

        if (fuhao.equals("+")){
            System.out.println(first + second);
        }
        if (fuhao.equals("-")){
            System.out.println(first - second);
        }
        if (fuhao.equals("*")){
            System.out.println(first * second);
        }
        if (fuhao.equals("/")){
            System.out.println(first / second);
        }
    }

}
