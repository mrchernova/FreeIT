package com.chernova.homework_9.notebookInterface;
/**
 * Вынести основные методы работы с записной книжкой в интерфейс
 */

import java.text.SimpleDateFormat;
import java.util.*;

public class NotebookMain {
    static Scanner sc = new Scanner(System.in);
    private static Random rand = new Random();

    public static void main(String[] args) {

        NoteType[] type = NoteType.values();
        ArrayList<Note> notes = new ArrayList<Note>();


        notes.add(new Note(new Date(122, rand.nextInt(13) + 1, rand.nextInt(32) + 1), type[1], "Запись1 ", "Разобрать бумаги"));
        notes.add(new Note(new Date(122, rand.nextInt(13) + 1, rand.nextInt(32) + 1), type[4], "Важное!!", "Совещание в 15:00. Не забыть ручку и кофе"));
        notes.add(new Note(new Date(122, rand.nextInt(13) + 1, rand.nextInt(32) + 1), type[0], "Задача", "Придумать себе работу"));
        notes.add(new Note(new Date(122, rand.nextInt(13) + 1, rand.nextInt(32) + 1), type[0], "Задача2", "Выпить кофе"));
        notes.add(new Note(new Date(122, rand.nextInt(13) + 1, rand.nextInt(32) + 1), type[3], "ДР", "20.01 Алегрова"));


        System.out.println("Список дел:");
        for (int i = 0; i < notes.size(); i++) {
            System.out.print(notes.get(i));
        }


        System.out.println();
        System.out.println("Найти запись");
        System.out.println("1. По слову");
        System.out.println("2. По дате");
        System.out.println("Выберите 1 или 2");

        int choice = sc.nextInt();


        switch (choice) {
            case 1:
                System.out.println("Введите слово для поиска:");
                String search = sc.next();

                Notebook note = new Note();
                System.out.print(note.findNote(notes, search).toString().replaceAll("^\\[|,|\\]$", ""));
                break;

            case 2:
                System.out.println("Введите диапазон для поиска записей");
                System.out.println(printFirstAndLastDate(notes));

                String dateFirst = sc.next();
                String dateLast = sc.next();

                Notebook date = new Note();
                System.out.print(date.findDate(notes, dateFirst, dateLast).toString().replaceAll("^\\[|,|\\]$", ""));
                break;

            default:
                System.out.println("Неверно выбран пункт");
        }
    }


    public static String printFirstAndLastDate(ArrayList<Note> notes) {
        // поиск первой и последней даты в записной книжке
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        Date minDate = notes.get(0).date;
        Date maxDate = notes.get(0).date;
        for (int i = 1; i < notes.size(); i++) {
            if (minDate.after(notes.get(i).date)) {
                minDate = notes.get(i).date;
            }
            if (maxDate.before(notes.get(i).date)) {
                maxDate = notes.get(i).date;
            }
        }
        return "Доступный диапазон от " + sdf.format(minDate) + " до " + sdf.format(maxDate);
    }


}
