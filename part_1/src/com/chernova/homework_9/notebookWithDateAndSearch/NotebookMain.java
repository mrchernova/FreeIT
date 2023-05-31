package com.chernova.homework_9.notebookWithDateAndSearch;
/**
 * Создать метод, возвращающий все запси в которых содержится переданное слово
 * Создать метод, возвращающий все запси в заданном промежутке времени
 */


import java.text.SimpleDateFormat;
import java.util.*;

public class NotebookMain {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Random rand = new Random();

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


        System.out.println("\n\nНайти запись");
        System.out.println("1. По слову");
        System.out.println("2. По дате");
        System.out.println("Выберите 1 или 2");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println(findNote(notes).toString().replaceAll("^\\[|,|\\]$", ""));
                break;
            case 2:
                System.out.println(findDate(notes).toString().replaceAll("^\\[|,|\\]$", ""));
                break;
            default:
                System.out.println("Неверно выбран пункт");
        }
    }


    public static ArrayList<Note> findDate(ArrayList<Note> notes) {
        // поиск первой и последней даты в записной книжке
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        ArrayList<Note> list = new ArrayList<>();

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

        System.out.println("Введите диапазон для поиска записей");
        System.out.println("Доступный диапазон от " + sdf.format(minDate) + " до " + sdf.format(maxDate));

        String dFirst;
        String dLast;
        dFirst = sc.next();
        dLast = sc.next();
        Date dateFirst = null;
        Date dateLast = null;

        try {
            dateFirst = sdf.parse(dFirst);
            dateLast = sdf.parse(dLast);
        } catch (Exception e) {
            System.out.println(e);
        }

        for (int i = 0; i < notes.size(); i++) {
            if (((notes.get(i).date.after(dateFirst)) || (notes.get(i).date.equals(dateFirst)))
                    && ((notes.get(i).date.before(dateLast)) || (notes.get(i).date.equals(dateLast)))) {
                list.add(notes.get(i));
            }
        }
        if (list.isEmpty()) {
            System.out.println("По данному запросу ничего не найдено");
        }
        return list;
    }


    public static ArrayList<Note> findNote(ArrayList<Note> notes) {

        System.out.println("Введите слово для поиска:");
        String s = sc.next();
        ArrayList<Note> list = new ArrayList<>();

        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).note.toLowerCase().contains(s)) {
                list.add(notes.get(i));
            }
        }
        if (list.isEmpty()){
            System.out.println("Ничего не найдено");
        }
        return list;
    }
}

