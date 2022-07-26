package com.chernova.homework_3;

/**
 * Написать 5 способов создания/получения строки
 */

public class Task2 {
    public static void main(String[] args) {
        String s1 = "hi";
        String s2 = new String("hey");
        String s3 = s1;
        String s4 = Integer.toString(42);
        String s5 = String.valueOf('h');  ;

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);

    }
}
