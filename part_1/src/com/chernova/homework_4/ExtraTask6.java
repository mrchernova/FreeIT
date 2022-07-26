package com.chernova.homework_4;

/**
 * получить ряд случайных чисел, и посчитать среднее геометрическое от них.
 * Ввод чисел прекращается, если очередным числом будет ноль.
 */

public class ExtraTask6 {
    public static void main(String[] args) {

        double geometricAverage = 0;
        double multiply = 1;
        int n = 0;
        int x = (int) (Math.random() * 20);
        System.out.print(x + " ");
        while (x != 0) {
            multiply *= x;
            n++;
            x = (int) (Math.random() * 20);
            System.out.print(x + " ");
        }
        if (n != 0) {
            geometricAverage = Math.pow(multiply, 1. / n);
        } else {
            geometricAverage = 0;
        }
        System.out.println();
        System.out.println("среднее геометрическое: " + geometricAverage);

    }
}

