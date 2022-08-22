package com.chernova.libraryXML;

import java.util.*;

public class Library {
    public static LinkedList<Book> list = new LinkedList<>();

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";



    //получить все книги (метод ВОЗВРАЩАЕТ список всех книг в библиотеке)
    public static LinkedList<Book> getAllBooks() {
        return list;
    }


    //  добавить книгу (принимает объект книги и добавляет его в список товаров)
    public static void addBook(Book book) {
        book.setId(Main.id++);
        book.setLocalDate(new Date());
        list.add(book);
        System.out.println(ANSI_GREEN + "Книга успешно добавлена" + ANSI_RESET);
    }






        //редактировать книгу (принимает объект книги и редактирует их список товаров)
        public static void editBook(Book book) {
            System.out.print("Выбранная книга:");
            System.out.println(book);

            System.out.println("Изменить название книги: ");
            System.out.println("(оставьте поле пустым, если не хотите его менять)");
            Main.sc.nextLine();
            String title = Main.sc.nextLine();
            if (!title.trim().isEmpty()) {
                book.setTitle(title);
            }

            System.out.println("Изменить содержание книги: ");
            System.out.println("(оставьте поле пустым, если не хотите его менять)");
            String text = Main.sc.nextLine();
            if (!text.trim().isEmpty()) {
                book.setText(text);
            }

            System.out.println("Изменить жанр книги: ");
            System.out.println(ANSI_YELLOW);
            Genre.printGenre();
            System.out.println(ANSI_RESET);




            boolean readyToSet = false;
            while (!readyToSet) {
                try {
                    readyToSet = true;
                    int genreAdd = Main.sc.nextInt();
                    book.setGenre(Genre.values()[genreAdd-1]);
                } catch (InputMismatchException e) {
                    System.out.println("Введите номер жанра");
                    readyToSet = false;
                    Main.sc.next();
                } catch ( ArrayIndexOutOfBoundsException e){
                    System.out.println("Выберите жанр из списка");
                    readyToSet = false;
                }
            }


            System.out.println("Изменить ISBN: ");
            System.out.println("(оставьте поле пустым, если не хотите его менять)");
            Main.sc.nextLine();
            String isbn = Main.sc.nextLine();
            if (!isbn.trim().isEmpty()) {
                book.setISBN(isbn);
            }

            System.out.println("Изменить дату публикации: ");
            System.out.println("(оставьте поле пустым, если не хотите его менять)");
            String publishDate = Main.sc.nextLine();
            if (!publishDate.trim().isEmpty()) {
                book.setPublishDate(publishDate);
            }


            book.setLocalDate(new Date()); //дата изменения книги
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
