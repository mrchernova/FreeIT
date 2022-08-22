package com.chernova.libraryXML;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static int id = 0;
    static Scanner sc = new Scanner(System.in);

    public static final String MAIN_MENU = "\n1. Получить список книг\n" +
            "2. Добавить книгу\n" +
            "3. Редактировать книгу\n" +
            "4. Удалить книгу\n" +
            "5. Сохранить библиотеку в файл\n" +
            "0. Выход";

    public static final String INNER_MENU = "\tВ каком порядке вывести книги?\n" +
            "\t1. По алфавиту А-Я\n" +
            "\t2. По алфавиту Я-А\n" +
            "\t3. По добавлению";

    public static void main(String[] args) {

        Library.list.add(id++,new Book("Убийство в Восточном экспрессе", "The plot of a story","1999-01-01","1-1111-1111-1",Genre.PHILOSOPHY,new Date()));
        Library.list.add(id++,new Book("Мастер и Маргарита", "The plot of a story","1999-01-02","1-1111-1111-1",Genre.HISTORY,new Date()));
        Library.list.add(id++,new Book("Рыжий Орм", "The plot of a story","1999-01-03","1-1111-1111-1",Genre.ADVENTURE, new Date()));
        Library.list.add(id++,new Book("Пикник на обочине", "The plot of a story","1999-01-04","1-1111-1111-1",Genre.DETECTIVE, new Date()));


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


                    System.out.print("title: ");
                    sc.nextLine();
                    newBook.setTitle(sc.nextLine());

                    System.out.print("text: ");
                    newBook.setText(sc.nextLine());

                    System.out.println("genre: ");
                    System.out.print(ANSI_YELLOW);
                    Genre.printGenre();
                    System.out.print(ANSI_RESET);
                    boolean readyToSet = false;
                    while (!readyToSet) {
                        try {
                            readyToSet = true;
                            int genreAdd = sc.nextInt();
                            newBook.setGenre(Genre.values()[genreAdd-1]);
                        } catch (InputMismatchException e) {
                            System.out.println("Введите номер жанра");
                            readyToSet = false;
                            sc.next();
                        } catch ( ArrayIndexOutOfBoundsException e){
                            System.out.println("Выберите жанр из списка");
                            readyToSet = false;
                        }
                    }

// написать обработчик 1                            //**********************************
                    System.out.print("isbn: ");
                    sc.nextLine();
                    newBook.setISBN(sc.nextLine());

// написать обработчик 2                            //*************************************
                    System.out.print("publish date: ");
                    newBook.setPublishDate(sc.nextLine());

                    Library.addBook(newBook);
                    break;





                case 3:
                    System.out.print("id книги: ");
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

                case 5:
                    try {
                        DocumentBuilder docParser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                        Document document = docParser.parse(ValidatorXSD.FILE_PATH + "book.xml");

                        BookInserter.addNewBook(document);

                        Node root = document.getDocumentElement();
                        System.out.println("List of books:");
                        System.out.println();
                        NodeList books = root.getChildNodes();
                        for (int i = 0; i < books.getLength(); i++) {
                            Node book = books.item(i);
                            if (book.getNodeType() != Node.TEXT_NODE) {
                                NodeList bookProps = book.getChildNodes();
                                for (int j = 0; j < bookProps.getLength(); j++) {
                                    Node bookProp = bookProps.item(j);
                                    if (bookProp.getNodeType() != Node.TEXT_NODE) {
                                        System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());
                                    }
                                }
                                System.out.println("\n");
                            }
                        }
                    } catch (ParserConfigurationException ex) {
                        ex.printStackTrace(System.out);
                    } catch (SAXException ex) {
                        ex.printStackTrace(System.out);
                    } catch (IOException ex) {
                        ex.printStackTrace(System.out);
                    }


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
