package com.chernova.homework_5;

import java.util.Random;

/**
 * Создать массив оценок произвольной длины, вывести максимальную и
 * минимальную оценку, её (их) номера.
 */

public class Task14 {
    public static void main(String[] args) {

        int[] marks = new int[30];
        Random random = new Random();
        String sMin = "", sMax = "";

        System.out.println("Массив оценок: ");
        for (int i = 0; i < marks.length; i++) {
            marks[i] = random.nextInt(10) + 1;
            System.out.print(marks[i] + " ");
        }
        System.out.println();

        int max = marks[0];
        int min = marks[0];

        for (int i = 0; i < marks.length; i++) {
            if (marks[i] <= min) min = marks[i];
            if (marks[i] >= max) max = marks[i];
        }
        System.out.println("Минимальная оценка: " + min);
        System.out.println("Максимальная оценка: " + max);


        for (int i = 0; i < marks.length; i++) {
            if (marks[i] == min) sMin = sMin + " " + i;
            if (marks[i] == max) sMax = sMax + " " + i;
        }
        System.out.println("Номер минимального элемента:" + sMin);
        System.out.println("Номер максимального элемента:" + sMax);

    }
}