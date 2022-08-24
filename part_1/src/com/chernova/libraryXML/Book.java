package com.chernova.libraryXML;

import java.util.Comparator;
import java.util.Date;

public class Book implements Comparable<Book>, Comparator<Book> {
    private int id;
    private String title;
    private String text;
    private String isbn;
    private Genre genre;
    private String publishDate;
    private Date localDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;

    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Date getLocalDate() {
        return localDate;
    }

    public void setLocalDate(Date localDate) {
        this.localDate = new Date();
    }

    public Book() {

    }

    public Book(String title, String text, String publishDate, String isbn, Genre genre, Date localDate) {
        this.title = title;
        this.text = text;
        this.genre = genre;
        this.publishDate = publishDate;
        this.isbn = isbn;
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "\nid " + id +
                "| title=" + title +
                "| text=" + text +
                "| genre=" + genre +
                "| isbn=" + isbn +
                "| publishDate=" + publishDate;
    }

    @Override
    public int compareTo(Book book) {
        return (this.title).toLowerCase().compareTo(book.title.toLowerCase());
    }

    // метод compare для сортировки по дате
    public int compare(Book book, Book book1) {
        if (book.localDate.before(book1.localDate)) {
            return 1;
        } else if (book.localDate.after(book1.localDate)) {
            return -1;
        } else {
            return 0;
        }
    }

}


