package com.chernova.homework_9.notebookInterface;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Note implements Notebook {
    protected Date date;
    protected NoteType type;
    protected String title;
    protected String note;


    public Note(Date date, NoteType type, String title, String note) {
        this.date = date;
        this.type = type;
        this.title = title;
        this.note = note;
    }

    public Note() {
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return "\n[" + sdf.format(date) + "][" + type + "][" + title + "] " + note;

    }


    @Override
    public ArrayList<Note> findNote(ArrayList<Note> notes, String search) {
        ArrayList<Note> list = new ArrayList<>();

        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).note.toLowerCase().contains(search)) {
                list.add(notes.get(i));
            }
        }
        if (list.isEmpty()) {
            System.out.println("Ничего не найдено");
        }
        return list;
    }


    @Override
    public ArrayList<Note> findDate(ArrayList<Note> notes, String dFirst, String dLast) {
        ArrayList<Note> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        Date dateFirst = null;
        Date dateLast = null;

        // Приведение формата String в Date
        try {
            dateFirst = sdf.parse(dFirst);
            dateLast = sdf.parse(dLast);
        } catch (Exception e) {
            System.out.println(e);
        }

        // проверяем попадает ли указанный диапазон дат в диапазон от первой до последней записи
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

}



