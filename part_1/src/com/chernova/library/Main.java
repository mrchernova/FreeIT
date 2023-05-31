package com.chernova.library;

import java.util.*;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";


    static Scanner sc = new Scanner(System.in);

    public static final String MAIN_MENU = "\n1. Получить список книг\n" +
            "2. Добавить книгу\n" +
            "3. Редактировать книгу\n" +
            "4. Удалить книгу\n" +
            "0. Выход";

    public static final String INNER_MENU = "\tВ каком порядке вывести книги?\n" +
            "\t1. По алфавиту А-Я\n" +
            "\t2. По алфавиту Я-А\n" +
            "\t3. По добавлению";

    public static void main(String[] args) {


        Library.list.add(new Book(1, "Убийство в \"Восточном экспрессе\"", "Детектив"));
        Library.list.add(new Book(2, "Мастер и Маргарита", "Роман"));
        Library.list.add(new Book(3, "Рыжий Орм", "Роман"));
        Library.list.add(new Book(4, "Пикник на обочине", "Фантастика"));


        int option = -1;
        while (option != 0) {
            System.out.println(ANSI_YELLOW + MAIN_MENU + ANSI_RESET);
            try {
                option = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Введите число");
                sc.next();
            }
            switch (option) {

                case 1:
                    System.out.println(ANSI_YELLOW + INNER_MENU + ANSI_RESET);
                    int nextOption = -1;
                    boolean done = false;
                    while (!done) {
                        try {
                            nextOption = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Введите число");
                            sc.next();
                        }
                        switch (nextOption) {
                            case 1:
                                Collections.sort(Library.list);
                                done = true;
                                break;
                            case 2:
                                Collections.reverse(Library.list);
                                done = true;
                                break;
                            case 3:
                                Collections.sort(Library.list, new Book());
                                done = true;
                                break;
                            default:
                                System.out.println("Выберите номер из списка");
                                break;
                        }
                    }
                    if (done) {
                        option = -1;
                        System.out.print("Список книг:");
                        System.out.println(Library.getAllBooks().toString().replaceAll("^\\[|,|\\]$", ""));
                        break;
                    }


                case 2:
                    Book newBook = new Book();
                    System.out.println("Заполните все поля для добавления книги");
                    System.out.print("id  книги: ");

                    int idAdd = -1;
                    boolean readyToSet = false;
                    while (!readyToSet) {
                        try {
                            readyToSet = true;
                            idAdd = sc.nextInt();
                            if (idAdd < 1) {
                                readyToSet = false;
                                System.out.println("id  книги должен быть положительным");
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("id это число. Введите id еще раз");
                            readyToSet = false;
                            sc.next();
                        }
                    }
                    newBook.setId(idAdd);
                    System.out.print("название  книги: ");
                    sc.nextLine();
                    newBook.setTitle(sc.nextLine());

                    System.out.println("жанр  книги:");
                    System.out.print(ANSI_YELLOW);
                    Genre.printGenre();
                    System.out.print(ANSI_RESET);

                    int genreAdd = -1;
                    readyToSet = false;
                    while (!readyToSet) {
                        try {
                            readyToSet = true;
                            genreAdd = sc.nextInt();

                            if (genreAdd < 1 || genreAdd > Genre.values().length) {
                                readyToSet = false;
                                System.out.println("Выберите жанр из списка");
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Введите номер жанра");
                            readyToSet = false;
                            sc.next();
                        }
                    }
                    newBook.setGenre(Genre.getGenreByID(genreAdd));
                    Library.addBook(newBook);
                    break;

                case 3:
                    System.out.print("id  книги: ");
                    try {
                        int idEdit = sc.nextInt();
                        boolean existBook = false;
                        for (int i = 0; i < Library.list.size(); i++) {
                            if (idEdit == Library.list.get(i).getId()) {
                                existBook = true;
                                Book chosenBook = Library.list.get(i);
                                Library.editBook(chosenBook);
                            }
                        }
                        if (!existBook) {
                            System.out.println(ANSI_RED + "Такой книги нет в списке" + ANSI_RESET);
                        }

                    } catch (InputMismatchException e) {
                        System.out.println(ANSI_RED + "Книга не найдена" + ANSI_RESET);
                        sc.next();
                    }
                    break;

                case 4:
                    System.out.println("Введите id книги, которую надо удалить");
                    try {
                        int idDel = sc.nextInt();
                        Library.delBook(idDel);

                    } catch (InputMismatchException e) {
                        System.out.println(ANSI_RED + "Книга не найдена" + ANSI_RESET);
                        sc.next();
                    }
                    break;

                case 0:
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Выберите номер из списка");
                    break;


            }
        }


    }


}
