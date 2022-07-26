package com.chernova.homework_7;

/**
 * Отсортировать записи в записной книжке по времени их добавления и вывеси в этом порядке в консоль
 */

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotebookSortByDate {
    public static void main(String[] args) {

        ArrayList<Note> notes = new ArrayList<Note>();

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String s = "";

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        System.out.println("Напишите задачу или нажмите \".\", если хотите перейти к списку");


        do {
            s = sc.nextLine();
            Pattern p = Pattern.compile("[\\s]+|[\\p{Punct}]+");
            Matcher m = p.matcher(s);
            if (!m.matches()) {
                notes.add(new Note(s.trim(), new Date(122, rand.nextInt(13) + 1, rand.nextInt(32) + 1)));
            }
        } while (!s.equals("."));


        System.out.println("список задач до сортировки:");
        for (Note i : notes) {
            System.out.println(i);
        }


        // алгоритм сортировки вставками
        ArrayList<Note> tmp = new ArrayList<Note>();
        for (int i = 1; i < notes.size(); i++) {
            tmp.add(0, notes.get(i));
            int j = i;
            while (j > 0 && notes.get(j - 1).date.after(tmp.get(0).date)) {
                notes.set(j, notes.get(j - 1));
                j--;
            }
            notes.set(j, tmp.get(0));
        }



        System.out.println("\nсписок задач после сортировки:");
        for (Note i : notes) {
            System.out.println(i);
        }

    }


    public static class Note {
        private String note;
        private Date date;

        public Note(String note, Date date) {
            this.note = note;
            this.date = date;
        }


        @Override
        public String toString() {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            return sdf.format(date) + " | " + note;
        }
    }
}
