package com.chernova.homework_9.notebookWithDateAndSearch;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {
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


}



