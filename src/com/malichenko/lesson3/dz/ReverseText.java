package com.malichenko.lesson3.dz;

import com.malichenko.lesson3.Stack;

import java.util.Arrays;
import java.util.Scanner;

//1. Создать программу, которая переворачивает вводимые строки (читает справа налево).
public class ReverseText {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to ReverseText, enter exit to exit the program");
        while (true) {
            System.out.print("Input text: ");
            String text = in.nextLine();
            if (text.equals("exit")) break;
            System.out.println("Your reverse text: " + reverse(text));
        }
        in.close();
    }

    public static String reverse(String input) {
        int size = input.length();
        Stack stack = new Stack(size);
        char[] charArray = input.toCharArray();
        for (char c: charArray) {
            stack.push(c);
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.append((char)stack.pop());
        }
        return result.toString();
    }
}

