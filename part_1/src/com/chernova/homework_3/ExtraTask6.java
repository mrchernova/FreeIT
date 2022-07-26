package com.chernova.homework_3;

import java.util.Random;

/**
 * Имеется целое число. Задать с помощью:
 * Random rand = new Random();
 * int x = rand.nextInt()
 * Это число – количество денег в рублях. Вывести это число, добавив к нему слово «рублей» в правильном падеже.
 */

public class ExtraTask6 {
    public static void main(String[] args) {

        Random rand = new Random();
        int x = rand.nextInt(1001);
        int n;

        if (x % 100 >= 11 && x % 100 <= 14) {
            System.out.println(x + " рублей");
        } else {
            n = x % 10;
            switch (n) {
                case 0:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    System.out.println(x + " рублей");
                    break;
                case 1:
                    System.out.println(x + " рубль");
                    break;
                case 2:
                case 3:
                case 4:
                    System.out.println(x + " рубля");
                    break;
            }
        }

    }
}
