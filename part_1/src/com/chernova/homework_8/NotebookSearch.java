package com.chernova.homework_8;

/**
 * Написать в классе записной книжки метод, который выводит в консоль название всех дел/сами дела,
 * в которых есть переданное в этот метод в качестве аргемента слово
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotebookSearch {
    public static void main(String[] args) {

        ArrayList<Note> notes = new ArrayList<Note>();

        Scanner sc = new Scanner(System.in);
        String search = "";

        notes.add(new Note("Запись1 ", "Разобрать бумаги"));
        notes.add(new Note("Важное!!", "Совещание в 15:00. Не забыть ручку и кофе"));
        notes.add(new Note("Задача", "Придумать как оптимизировать работу"));
        notes.add(new Note("Задача2", "Выпить кофе"));

        System.out.println("Список дел:");
        printNote(notes);

        System.out.println("\nВведите слово для поиска:");
        search = sc.nextLine();

        searchNote(notes, search);
        sc.close();
    }


    public static void printNote(ArrayList<Note> notes) {
        for (int i = 0; i < notes.size(); i++) {
            System.out.println(notes.get(i));
        }
    }


    public static void searchNote(ArrayList<Note> notes, String search) {
        boolean isMatch = false;

        if (!search.equals("")) {
            for (int i = 0; i < notes.size(); i++) {

                if (notes.get(i).note.contains(search)) {
                    System.out.println(notes.get(i));
                    isMatch = true;
                }
            }
        }

        if (!isMatch || search.equals("")) {
            System.out.println("Совпадений не найдено");
        }
    }

    public static class Note {
        private String title;
        private String note;

        public Note(String title, String note) {
            this.title = title;
            this.note = note;
        }

        @Override
        public String toString() {
            return "[" + title + "] >> " + note;
        }
    }
}