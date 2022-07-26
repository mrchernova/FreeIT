package com.chernova.homework_5;

/**
 * Написать программу, которая будет хранить текст по предложениям
 * и для каждого предложения составить частотный словарь
 */

public class Vocabulary {
    public static void main(String[] args) {

        String s = "Во дворе трава на траве дрова не руби дрова на траве двора. Пара пара пам";
        s = s.toLowerCase();

        String[] sentences = s.split("[!?.]");

        // для каждого предложения будут выполнены следующие действия:
        for (int x = 0; x < sentences.length; x++) {

            System.out.println();
            System.out.println(sentences[x].trim());

            String[] words = sentences[x].trim().split(" ");    // каждое предложение будет разбито на слова

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
                    if (words[i].equals(vocabulary[v])) consist = true;
                }

                // если в словаре еще нет таких слов, то можно заносить
                if (!consist) {
                    vocabulary[i] = words[i];
                    n[i] = count;
                }
            }

            // Вывод словаря без пустых элементов
            for (int i = 0; i < n.length; i++) {
                if (n[i] != 0) System.out.println("Слово в предложении: " + vocabulary[i] + " " + n[i]);
            }

        }

    }
}
