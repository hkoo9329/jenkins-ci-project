package com.jenkins.ci.project;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);

        int x,y;
        String symbol;

        System.out.println("계산할 숫자 두개를 입력하세요.");
        x = in.nextInt();
        y = in.nextInt();
        System.out.println("두 수를 처리할 연산자를 입력하세요.");
        symbol = in.next();

        if(symbol.equals("+")){
            System.out.println(x+y);
        } else if( symbol.equals("-")){
            System.out.println(x-y);
        } else if(symbol.equals("*")){
            System.out.println(x*y);
        } else if(symbol.equals("/")){
            if(y == 0) {
                System.out.println("분모는 0이 될수 없습니다.");
                return;
            }
            System.out.println(x/y);
        } else{
            System.out.println("정확한 기호를 입력하세요.");
        }

    }


}
