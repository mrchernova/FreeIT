package com.chernova.homework_9.notebookInterface;

import java.util.ArrayList;

public interface Notebook {

    ArrayList findNote(ArrayList<Note> notes, String s);

    ArrayList findDate(ArrayList<Note> notes, String dateFirst, String dateLast);

}
