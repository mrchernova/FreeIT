package com.chernova.homework_6;

import java.util.Scanner;

/**
 * Создать класс записной книжки, в котором хранятся записи дел.
 * Создать в этом классе метод, который выводит частотный словарь для определенной записи
 * (запись можно определить по номеру/индексу)
 */

public class Notebook {
    public static void main(String[] args) {
        String notes = "Зайти в магазин. Покормить кота. Вынести мусор. Создать метод в классе в котором хранятся записи дел";
        String[] note = notes.split("[.?!]");
        byte item;

        printNotes(note);

        Scanner sc = new Scanner(System.in);
        System.out.println("\nВыберите номер записи из списка ");
        while (!sc.hasNextByte()) {
            System.out.println("Необходимо ввести номер записи ");
            sc.next();
        }
        item = sc.nextByte();
        while (item > note.length || item <= 0) {
            System.out.println("Выберите номер существующей записи ");
            item = sc.nextByte();
        }

        vocabulary(note, --item);
    }


    public static void vocabulary(String[] note, int x) {

        System.out.println("Вы выбрали запись - " + note[x].trim());

        String[] words = note[x].toLowerCase().trim().split(" ");

        String[] vocabulary = new String[words.length]; // переменная для словаря
        int[] n = new int[words.length];                // переменная для подсчета слов


        // поиск и подсчет повторений слов в строке
        for (int i = 0; i < words.length; i++) {
            boolean consist = false;
            int count = 0;

            for (int j = i; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    count++;
                }
            }

            // проверка очередного слова с теми, что уже есть в словаре
            for (int v = 0; v < vocabulary.length; v++) {
                if (words[i].equals(vocabulary[v])) {
                    consist = true;
                }
            }

            // если в словаре еще нет таких слов, то можно заносить
            if (!consist) {
                vocabulary[i] = words[i];
                n[i] = count;
            }
        }

        // Вывод словаря без пустых элементов
        for (int i = 0; i < n.length; i++) {
            if (n[i] != 0) System.out.println("Слово: " + vocabulary[i] + " " + n[i]);
        }

    }


    public static void printNotes(String[] note) {
        for (int i = 0; i < note.length; i++) {
            System.out.println(i + 1 + ". " + note[i].trim());
        }
    }

}
