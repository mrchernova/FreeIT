package com.chernova.library;

import java.util.Comparator;
import java.util.Date;

public class Book implements Comparable<Book>, Comparator<Book> {
    private int id;
    private String title;
    private String genre;
    public Date date;


    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }


    public Book() {
        this.date = new Date();
    }

    public Book(int id, String title, String genre) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.date = new Date();
    }

    public Book(int id, String title, String genre, Date date) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "\nid=" + id +
                " | " + title +
                " | " + genre;

    }


    @Override
    public int compareTo(Book book) {
        return (this.title).toLowerCase().compareTo(book.title.toLowerCase());
    }


    // метод compare для сортировки по дате
    public int compare(Book book, Book book1) {

        if (book.date.before(book1.date)) {
            return 1;
        } else if (book.date.after(book1.date)) {
            return -1;
        } else {
            return 0;
        }
    }


}



