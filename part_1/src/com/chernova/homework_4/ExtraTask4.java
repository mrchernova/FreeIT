package com.chernova.homework_4;

import java.util.Random;

/**
 * Имеется целое число, определить является ли это число простым, т.е.
 * делится без остатка только на 1 и себя
 * prime - простое
 * composite - составное
 */

public class ExtraTask4 {
    public static void main(String[] args) {

        Random rand = new Random();
        int x = rand.nextInt(101);
        boolean primeNumber = true;

        if (x < 2) System.out.println(x + " no prime and no composite number");
        else {

            for (int i = 2; i <= Math.sqrt(x); i++) {
                if (x % i == 0) {
                    primeNumber = false;
                    break;
                }
            }
            if (primeNumber) System.out.println(x + " - prime number");
            else System.out.println(x + " - composite number");

        }

    }
}
