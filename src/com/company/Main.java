package com.company;
import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
            System.out.println("Введите арифметическую операцию по шаблону: a + b,  a - b, a / b, a * b");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();
            System.out.println(calc(str));
    }

    public static String calc (String input) {
        String result = "";
        int a = 0; int b = 0;
        boolean arab = true;

        String[] token = input.split(" ");
        if (token.length > 3)
            try {
                throw new CalcException("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            } catch (CalcException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        if (token.length < 3)
            try {
               throw new CalcException("//т.к. строка не является математической операцией");
            } catch (CalcException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }

            try {
             a = Integer.parseInt(token[0]);
             b = Integer.parseInt(token[2]);
            }
             catch (NumberFormatException e) {
            try {
               a = Roman.valueOf(token[0]).getTranslation();
               b = Roman.valueOf(token[2]).getTranslation();
               arab = false;
            }
            catch (IllegalArgumentException q) {
               System.out.println("т.к. неверный формат чисел");
               System.exit(0);
            }
            }

        if ((a>10)||(b>10))
            try {
                throw new CalcException("//Калькулятор может принимать на вход числа от 1 до 10 включительно");
            } catch (CalcException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }

        switch (token[1]) {
            case "+":
                result = Integer.toString(a+b);
                break;
            case "-":
                result = Integer.toString(a-b);
                break;
            case "*":
                result = Integer.toString(a*b);
                break;
            case "/":
                result = Integer.toString(a/b);
                break;
            default:
                try {
                    throw new CalcException("//throws Exception //т.к. строка не является математической операцией");
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                    System.exit(0);
                }
        }

        if (!arab) {
            if (Integer.parseInt(result)<=0)
               try {
                   throw new CalcException("throws Exception //т.к. в римской системе нет отрицательных чисел или нуля");
               } catch (CalcException e) {
                    System.out.println(e.getMessage());
                    System.exit(0);
               }
       // result = Roman.values()[Integer.parseInt(result)-1].name();
        result = Roman.getRoman(Integer.parseInt(result)).name();

        }
        return result;

    }
}
