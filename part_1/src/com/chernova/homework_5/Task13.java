package com.chernova.homework_5;

import java.util.Random;

/**
 * Создать последовательность случайных чисел,
 * найти и вывести наибольшее из них.
 */

public class Task13 {
    public static void main(String[] args) {

        int[] arrayInt = new int[10];
        Random random = new Random();

        System.out.println("Дан массив чисел: ");
        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = random.nextInt(100);
            System.out.print(arrayInt[i] + " ");
        }
        System.out.println();

        int max = arrayInt[0];
        for (int i = 0; i < arrayInt.length; i++) {
            if (arrayInt[i] >= max) max = arrayInt[i];

        }
        System.out.println("Максимальный элемент в массиве: " + max);

    }
}