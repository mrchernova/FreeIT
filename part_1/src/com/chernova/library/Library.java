package com.chernova.library;

import java.util.*;

public class Library {
    public static LinkedList<Book> list = new LinkedList<>();
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";


    //получить все книги (метод ВОЗВРАЩАЕТ список всех книг в библиотеке)
    public static LinkedList<Book> getAllBooks() {
        if (list.isEmpty()) {
            System.out.println("Библиотека пуста");
        }
        return list;
    }


    //  добавить книгу (принимает объект книги и добавляет его в список товаров)
    public static void addBook(Book book) {
        boolean isExistBook = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == book.getId()) {
                isExistBook = true;
                break;
            }
        }
        if (isExistBook) {
            System.out.println(ANSI_RED + "Книга с id = " + book.getId() + " уже существует" + ANSI_RESET);
        } else {
            list.add(book);
            System.out.println(ANSI_GREEN + "Книга успешно добавлена" + ANSI_RESET);
        }
    }


    //редактировать книгу (принимает объект книги и редактирует их список товаров)
    public static void editBook(Book book) {
        System.out.print("Выбранная книга:");
        System.out.println(book);


        System.out.println();
        System.out.print("Изменить id книги: ");


// не изменять книгу, если указан id  существующей (кроме id изменяемой книги)
        int idEdit = -1;
        boolean readyToSet = false;
        while (!readyToSet) {
            try {
                readyToSet = true;
                idEdit = Main.sc.nextInt();
                if (idEdit < 1) {
                    readyToSet = false;
                    System.out.println("id  книги должен быть положительным");
                }
                //проверка на наличие такого id в списке (кроме текущего id)
                if (idEdit == book.getId()) {
                    readyToSet = true;
                } else {
                    for (int i = 0; i < Library.list.size(); i++) {
                        if (idEdit == Library.list.get(i).getId()) {
                            readyToSet = false;
                            System.out.println("Книга с таким id  уже существует. Выберите другой id");
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("id это число. Введите id еще раз");
                readyToSet = false;
                Main.sc.next();
            }

        }
        book.setId(idEdit);

        System.out.println("Изменить название книги: ");
        System.out.println("(оставьте поле пустым, если не хотите его менять)");
        Main.sc.nextLine();
        String title = Main.sc.nextLine();
        if (!title.trim().isEmpty()) {
            book.setTitle(title);
        }

        System.out.println("Изменить жанр книги: ");
        System.out.println(ANSI_YELLOW);
        Genre.printGenre();
        System.out.println(ANSI_RESET);

        int genreEdit = -1;
        readyToSet = false;
        while (!readyToSet) {
            try {
                readyToSet = true;
                genreEdit = Main.sc.nextInt();

                if (genreEdit < 1 || genreEdit > Genre.values().length) {
                    readyToSet = false;
                    System.out.println("Выберите жанр из списка");
                }

            } catch (InputMismatchException e) {
                System.out.println("Введите номер жанра");
                readyToSet = false;
                Main.sc.next();
            }
        }
        book.setGenre(Genre.getGenreByID(genreEdit));

        book.date = new Date();
        System.out.println(ANSI_GREEN + "Данные изменены" + ANSI_RESET);
    }


    //удалить книгу (метод принимает id книги и удаляет из списка книгу с соответствующим id)
    public static void delBook(int id) {
        boolean isDelete = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                isDelete = true;
                break;
            }
        }
        if (isDelete) {
            System.out.println(ANSI_GREEN + "Книга успешно удалена" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Книги с таким id нет в списке" + ANSI_RESET);
        }
    }


}
