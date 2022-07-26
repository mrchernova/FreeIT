package com.chernova.homework_6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Имеется строка с текстом. Подсчитать количество слов в тексте.
 * Слова могут разделяться несколькими пробелами.
 * В начале и конце текста тоже могут быть пробелы.
 */

public class Task19 {
    public static void main(String[] args) {
        String s = "  Дана строка    с    несколькими пробелами между   словами.    Сколько слов в строке? ";
        System.out.println(s);
        int n = 0;

        Pattern p = Pattern.compile("[\\p{IsWord}]+");
        Matcher m = p.matcher(s);

        while (m.find()) {
            n++;
        }
        System.out.println("Количество слов в строке: " + n);
    }
}