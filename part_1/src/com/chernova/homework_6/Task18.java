package com.chernova.homework_6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Найти в строке не только запятые, но и другие знаки препинания.
 * Подсчитать общее их количество.
 */

public class Task18 {
    public static void main(String[] args) {

        String s = "Найти в строке не только запятые, но и другие знаки препинания... Подсчитать общее их количество.";
        int n = 0;

        System.out.println("Дана строка:");
        System.out.println(s);

        Pattern p2 = Pattern.compile("([.]{3})|(\\p{Punct})");
        Matcher m2 = p2.matcher(s);

        while (m2.find()) {
            n++;
        }

        System.out.println("Знаков препинания в строке = " + n);
    }
}
