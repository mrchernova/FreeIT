package com.chernova.homework_7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Написать программу, выполняющую поиск в строке шестнадцатиричных чисел,
 * записынных по правилам Java, с помощью регулярных выражений
 * и вывести их на страницу
 */

public class Task22HexadecimalNumbers {
    public static void main(String[] args) {
        String s = "Дана строка F3 akfjmkeF2C22A3B6C A18Alvvdaafle!!!30";

        Pattern p = Pattern.compile("[A-F0-9a-f]{1,}");
        Matcher m = p.matcher(s);

        while (m.find()) {
            System.out.println("Hexadecimal | " + m.group());
        }

    }
}
