package com.chernova.homework_5;

import java.util.Random;

/**
 * Определите сумму элементов одномерного массива, расположенных между
 * минимальным и максимальным значениями.
 */

public class Task16 {
    public static void main(String[] args) {
        int[] array = new int[5];
        Random random = new Random();

        System.out.println("Массив: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
            System.out.print(array[i] + " ");
        }
        System.out.println();


        int min = array[0];
        int mini = 0;
        int max = array[0];
        int maxi = 0;

        int sum = 0;

        // Получаем первый минимальный и последний максимальный элементы
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                mini = i;
            }
            if (array[i] >= max) {
                max = array[i];
                maxi = i;
            }
        }


        // если минимальный > максимального, искать первый максимальный и последний минимальный
        if (mini > maxi) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] < max) {
                    max = array[i];
                    maxi = i;
                }
                if (array[i] >= min) {
                    min = array[i];
                    mini = i;
                }
            }
        }

        // Сумма элементов между максимальным и минимальным
        if (mini < maxi) {
            for (int i = mini; i <= maxi; i++) {
                sum += array[i];
            }
        } else {
            for (int i = maxi; i <= mini; i++) {
                sum += array[i];
            }
        }
        System.out.println("Сумма элементов расположеных между минимальным и максимальным элементами равна " + sum);

    }
}





