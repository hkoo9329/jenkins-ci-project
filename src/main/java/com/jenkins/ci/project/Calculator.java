package com.jenkins.ci.project;

import lombok.Data;

import java.util.Stack;

@Data
public class Calculator {
    private String output = "";
    private String input = "";

    public Calculator(String data) throws CalException {
        setInput(data);
        Calculation();
    }


    public void Calculation() throws CalException {
        Stack<Float> st = new Stack<Float>();
        char[] temp = input.toCharArray();
        float x, y, result;
        for (int i = 0; i < temp.length; i++) {

            switch (temp[i]) {
                case '+':
                    x = st.pop();
                    y = st.pop();
                    result = x + y;
                    st.push(result);
                    break;
                case '-':
                    x = st.pop();
                    y = st.pop();
                    result = x - y;
                    st.push(result);
                    break;
                case '*':
                    x = st.pop();
                    y = st.pop();
                    result = x * y;
                    st.push(result);
                    break;
                case '/':
                    x = st.pop();
                    y = st.pop();
                    result = x / y;
                    st.push(result);
                    break;
                default:
                    st.push(Float.parseFloat(String.valueOf(temp[i])));
                    break;
            }
        }

        if (st.size() > 1) {
            throw (new CalException("수식이 잘못 되었습니다."));
        } else
            setOutput(String.valueOf(st.pop()));

    }

}

class CalException extends Exception {

    public CalException(String message) {
        super(message);
    }
}
