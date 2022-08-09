package com.chernova.homework_9.notebookWithEnum;

public enum NoteType {
    TASKS,
    EVENTS,
    HOLIDAYS,
    BIRTHDAYS,
    REMINDERS,
    PURCHASES;


    public static NoteType getTypeByNum2(int num) {
        NoteType[] type = NoteType.values();
        if (num <= type.length && num > 0) {
           return type[num - 1];
        }
        return null;
    }

}
