package com.chernova.homework_4;

import java.util.Scanner;

/**
 * Найдите сумму первых n целых чисел, которые делятся на 3
 */

public class ExtraTask5 {
    public static void main(String[] args) {

        int x = 0;
        int i = 3;
        int sum = 0;
        int amount;

        Scanner scAmount = new Scanner(System.in);
        System.out.println("Сколько первых чисел, которые будут делиться на 3 нужно найти? ");
        while (!scAmount.hasNextInt()) {
            System.out.println("Нужно вводить только целые числа. Попробуйте еще раз ");
            scAmount.next();
        }

        amount = scAmount.nextInt();
        while (amount < 1) {
            System.out.println("Число должо быть больше 0. Еще попытка ");
            amount = scAmount.nextInt();
        }

        while (x < amount) {
            if (i % 3 == 0) {
                sum = sum + i;
                x++;
                i++;
            } else i++;
        }
        System.out.println("Сумма первых " + amount + " чисел, которые делятся на 3 равна " + sum);
    }
}
