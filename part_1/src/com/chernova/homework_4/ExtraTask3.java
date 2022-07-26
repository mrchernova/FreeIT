package com.chernova.homework_4;

/**
 * Посчитать факториал числа в границах от 10 до 15 (не используя рекурсию)
 */

public class ExtraTask3 {
    public static void main(String[] args) {

        for (int i = 10; i <= 15; i++) {
            int res = 1;
            for (int j = 1; j <= i; j++) {
                res = res * j;
            }
            System.out.println("Factorial " + i + " = " + res);
        }

    }
}
