package com.chernova.homework_3;

/**
 * Создайте число. Определите, является ли число трехзначным. Определите, является
 * ли его последняя цифра семеркой. Определите, является ли число четным.
 */

public class ExtraTask4 {
    public static void main(String[] args) {
        int num = -123;
        num = Math.abs(num);

        if (num > 99 && num <= 999) System.out.println("number " + num + " is three-digit");
        else System.out.println("number " + num + " is not three-digit");

        if (num % 10 == 7) System.out.println("yes, last digit is " + num % 10);
        else System.out.println("no, last digit is " + num % 10);

        if (num == 0) System.out.println("digit " + num + " is not even and not odd");
        else if (num % 2 == 0) System.out.println("number " + num + " is even");
        else System.out.println("number " + num + " is odd");
    }
}
