package com.chernova.homework_6;

/**
 * Имеется строка с текстом. Вывести текст, составленный из последних букв всех слов.
 */

public class Task20 {
    public static void main(String[] args) {

        String s = "  Вот такая вот строка    дана9. С точками  , запятыми и   лишними пробелами  ";
        System.out.println(s);

        s = trimString(s);

        System.out.println("\nТекст, составленный из последних букв всех слов: ");
        eachLastLetter(s);

    }

    // удаляет лишние символы и пробелы
    public static String trimString(String s) {
        s = s.replaceAll("[\\p{Punct}0-9]", "");
        s = s.trim();
        char[] c = s.toCharArray();

        s = "";
        for (int i = 0; i < c.length; i++) {
            s += c[i];

            while ((c[i] == ' ') && (c[i + 1] == ' ')) {
                i++;
            }
        }
        return s;
    }

    //  выводит последнюю букву каджого слова
    public static void eachLastLetter(String s) {
        String[] sArray = s.split(" ");
        s = "";

        for (int i = 0; i < sArray.length; i++) {
            s += sArray[i].substring(sArray[i].length() - 1);
        }
        System.out.println(s);
    }

}
