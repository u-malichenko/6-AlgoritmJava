package com.malichenko.lesson3.dzFix;


import com.malichenko.lesson3.Stack;

public class Homework {

    private static String fancyReverse(String s) {
        Stack stack = new Stack(s.length());
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append((char) stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(fancyReverse("HelloWorld"));
    }
}
