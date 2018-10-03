package com.jenkins.ci.project;

import java.util.Scanner;
import java.util.Stack;

public class mainInput {

    public static void main(String[] args) throws CalException {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        System.out.println("정수 계산기 종료: exit 입력");

        while (true){
            String data;
            data = in.nextLine();
            if(data.equals("exit")){
                break;
            }
            Calculator cal = new Calculator(infixToPostfix(data));
            System.out.println(cal.getOutput());
        }




    }
    private static int getWeight(char op){
        switch (op){
            case '(': case ')': return 0;
            case '+': case '-': return 1;
            case '*': case '/': return 2;
        }
        return -1;
    }
    public static String infixToPostfix(String data){
        String input ="";
        Stack<Character> st = new Stack<Character>();
        char[] ch_array = data.toCharArray();
        char temp;
        for(int i=0; i<ch_array.length;i++){

            switch (ch_array[i]){
                case '+': case '-': case '*': case '/':
                    while (!st.isEmpty() && getWeight(ch_array[i]) <= getWeight(st.peek()))
                        input +=st.pop();
                    st.push(ch_array[i]);
                    break;
                case '(':
                    st.push(ch_array[i]);
                    break;
                case ')':
                    temp = st.pop();

                    while(temp != '('){
                        input+=temp;
                        temp = st.pop();
                    }
                    break;

                default:
                    input+=ch_array[i];
                    break;
            }
        }

        while (!st.isEmpty())
            input+=st.pop();


        return input;
    }

}
