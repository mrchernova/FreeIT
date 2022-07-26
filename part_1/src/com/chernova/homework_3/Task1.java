package com.chernova.homework_3;

import java.util.Scanner;

/**
 * Написать программу, которая приветствует пользователя в зависимости от его пола и возраста
 * (имя, пол и возраст задаются при старте программы)
 */

public class Task1 {
    public static void main(String[] args) {
        int age = 0;
        String name = "";
        String sex;

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите свой возраст: ");
        while (!sc.hasNextInt()) {
            System.out.println("Корректно введите свой возраст ");
            sc.next();
        }
        age = sc.nextInt();
        while (age < 0) {
            System.out.println("Корректно введите данные ");
            age = sc.nextInt();
        }


        System.out.println("Введите свое имя: ");
        sc.nextLine(); // без этого не читает строку после sc.nextInt
        name = sc.nextLine();


        System.out.println("Укажите свой пол (м или ж)(m or f) ");
        do {
            sex = sc.nextLine();
        } while (!sex.equals("м") && !sex.equals("ж") && !sex.equals("m") && !sex.equals("f"));


        switch (sex) {
            case "m":
            case "м":
                if (age > 50) {
                    System.out.print("Добрый день, уважаемый " + name);
                } else {
                    System.out.print("Привет, красавчик " + name);
                }
                break;
            case "f":
            case "ж":
                if (age > 50) {
                    System.out.print("Добрый день, уважаемая " + name);
                } else {
                    System.out.print("Привет, красавица " + name);
                }
                break;
        }

    }
}
