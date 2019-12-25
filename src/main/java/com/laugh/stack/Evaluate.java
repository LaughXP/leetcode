package com.laugh.stack;

import java.util.Stack;

/**
 * @author yu.gao 2019-12-05 7:47 PM
 */
public class Evaluate {

    public static void main(String[] args) {
        //( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
        String[] array = new String[]{"(", "1", "+", "(" , "(" , "2" , "+" ,"3" ,")","*","(","4","*","5",")",")",")"};
        cal(array);
    }

    private static void cal(String[] array) {
        if(array == null || array.length == 0) {
            return;
        }
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<Double>();
        for(String s : array) {
            if("(".equals(s)) {
                continue;
            } else if("+".equals(s)) {
                ops.push(s);
            } else if("-".equals(s)) {
                ops.push(s);
            } else if("*".equals(s)) {
                ops.push(s);
            } else if("/".equals(s)) {
                ops.push(s);
            } else if(")".equals(s)) {
                //运算
                String op = ops.pop();
                Double val = vals.pop();
                if("+".equals(op)) {
                    vals.push(val + vals.pop());
                } else if("-".equals(op)) {
                    vals.push(val - vals.pop());
                } else if("*".equals(op)) {
                    vals.push(val * vals.pop());
                } else if("/".equals(op)) {
                    vals.push(val / vals.pop());
                }
            } else {
                vals.push(Double.valueOf(s));
            }
        }
        System.out.println(vals.pop());
    }
}
