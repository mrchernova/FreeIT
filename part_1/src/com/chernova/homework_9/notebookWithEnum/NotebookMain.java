package com.chernova.homework_9.notebookWithEnum;
/**
 * Добавить каждой записи в записной книге поле типа (еnum): покупки/дела/звонки...
 * Защитить записи от возможности изменения "снаружи"
 * Создать метод, возвращающий все запси переданного в метод типа
 */

import java.util.ArrayList;
import java.util.Scanner;

public class NotebookMain {
    public static void main(String[] args) {

        NoteType[] type = NoteType.values();

        ArrayList<Note> notes = new ArrayList<Note>();

        Scanner sc = new Scanner(System.in);
        int num;

        notes.add(new Note(type[1], "Запись1 ", "Разобрать бумаги"));
        notes.add(new Note(type[4], "Важное!!", "Совещание в 15:00. Не забыть ручку и кофе"));
        notes.add(new Note(type[0], "Задача", "Придумать себе работу"));
        notes.add(new Note(type[0], "Задача2", "Выпить кофе"));
        notes.add(new Note(type[3], "ДР", "20.01 Алегрова"));


        System.out.println("Список дел:");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println(notes.get(i));
        }

        System.out.println("\nВыберите записи определенного типа. Введите номер нужного типа");
        for (int i = 0; i < type.length; i++) {
            System.out.println((i + 1) + " " + type[i]);
        }

        num = sc.nextInt();
        boolean noteExist = false;
        for (int i = 0; i < notes.size(); i++) {
            if (NoteType.getTypeByNum2(num) == notes.get(i).type) {
                System.out.println(notes.get(i));
                noteExist = true;
            }

        }
        if (!noteExist || NoteType.getTypeByNum2(num)==null) {
            System.out.println("Нет записей");
        }
    }


    public static class Note {
        private String title;
        private String note;
        private NoteType type;

        public Note(NoteType type, String title, String note) {
            this.title = title;
            this.note = note;
            this.type = type;
        }

        @Override
        public String toString() {
            return "[" + type + "]" + "[" + title + "] >> " + note;
        }
    }
}