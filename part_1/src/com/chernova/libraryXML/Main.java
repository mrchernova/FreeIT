package com.chernova.libraryXML;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;


public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";

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


    //public static String FILE_PATH = "part_1/src/com/chernova/libraryXML/";       // H
    public static String FILE_PATH = "freeit/part_1/src/com/chernova/libraryXML/";  // W

    public static String tag = "";
    public static Book newBookFromXML;


    public static void main(String[] args) {

        // проверка xml на валидность. Если успешно, то с помощью метода printInfoAboutAllChildNodes() добавляет книги из xml в библиотеку
        boolean answer = ValidatorXSD.validateXMLSchema(FILE_PATH + "book.xsd", FILE_PATH + "book.xml");
        if (answer) {
            System.out.println("Файл book.xml соответствует схеме");
            try {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(FILE_PATH + "book.xml");

                String element = "books";
                NodeList matchedElementsList = document.getElementsByTagName(element);
                if (matchedElementsList.getLength() == 0) {
                    System.out.println("<" + element + "> не был найден в файле.");

                } else {
                    Node foundedElement = matchedElementsList.item(0);
                    if (foundedElement.hasChildNodes()) {
                        printInfoAboutAllChildNodes(foundedElement.getChildNodes());
                    }
                }
            } catch (ParserConfigurationException ex) {
                ex.printStackTrace(System.out);
            } catch (SAXException ex) {
                ex.printStackTrace(System.out);
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        } else {
            System.out.println("Файл book.xml не соответствует схеме");
            System.out.println("При работе с программой файл .xml не будет учтен");
        }


        // Книги, которые уже есть в библиотеке
        Book testBook = new Book();
        testBook.setTitle("The Sundered Grail");
        testBook.setText("The two daughters of Maeve, half-sisters, battle one another for control of England. Sequel to, Oberon's Legacy");
        testBook.setPublishDate("2001-09-10");
        testBook.setISBN("1-1111-1111-1");
        testBook.setGenre(Genre.FANTASY);
        Library.addBook(testBook);

        Book testBook1 = new Book();
        testBook1.setTitle("Lover Birds");
        testBook1.setText("When Carla meets Paul at an ornithology conference, tempers fly as feathers get ruffled");
        testBook1.setPublishDate("2000-09-02");
        testBook1.setISBN("1-1111-1111-2");
        testBook1.setGenre(Genre.ROMANCE);
        Library.addBook(testBook1);


        // работа с меню
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
                            newBook.setGenre(Genre.values()[genreAdd - 1]);
                        } catch (InputMismatchException e) {
                            System.out.println("Введите номер жанра");
                            readyToSet = false;
                            sc.next();
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Выберите жанр из списка");
                            readyToSet = false;
                        }
                    }

                    System.out.print("Введите 10-ый код isbn в формате: х-хххх-хххх-х ");
                    sc.nextLine();
                    String inputISBN = sc.nextLine();
                    boolean check = false;
                    while (!check) {
                        if (inputISBN.matches("[0-9]-[0-9]{4}-[0-9]{4}-[0-9]")) {
                            check = true;
                        } else {
                            System.out.println("Введенный isbn не соответствует формату. Попробуйте еще раз ");
                            inputISBN = sc.nextLine();
                        }
                    }
                    newBook.setISBN(inputISBN);

                    System.out.print("Введите дату публикации в формате: yyyy-MM-dd ");
                    String publishDate = sc.nextLine();
                    check = false;
                    while (!check) {
                        if (publishDate.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
                            check = true;
                        } else {
                            System.out.println("Введенная дата не соответствует формату. Попробуйте еще раз ");
                            publishDate = sc.nextLine();
                        }
                    }
                    newBook.setPublishDate(publishDate);

                    Library.addBook(newBook);
                    System.out.println(ANSI_GREEN + "Книга успешно добавлена" + ANSI_RESET);
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
                        Document document = docParser.parse(FILE_PATH + "book.xml");

                        Library.addBooksToXML(document);
                    //    System.out.println(ANSI_GREEN + "Файл записан на диск"+ ANSI_RESET);

//                        Node root = document.getDocumentElement();
//                        System.out.println("doc " + document.getDocumentElement());
//
//                        System.out.println("List of books:");
//                        System.out.println();
//
//                        NodeList books = root.getChildNodes();
//
//                        for (int i = 0; i < books.getLength(); i++) {
//                            Node book = books.item(i);
//
//                            if (book.getNodeType() != Node.TEXT_NODE) {
//                                NodeList bookProps = book.getChildNodes();
//
//                                for (int j = 0; j < bookProps.getLength(); j++) {
//                                    Node bookProp = bookProps.item(j);
//
//                                    if (bookProp.getNodeType() != Node.TEXT_NODE) {
//                                        System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());
//                                    }
//                                }
//                                System.out.println("\n");
//                            }
//                        }

                    } catch (ParserConfigurationException ex) {
                        ex.printStackTrace(System.out);
                    } catch (SAXException ex) {
                        ex.printStackTrace(System.out);
                    } catch (IOException ex) {
                        ex.printStackTrace(System.out);
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


    //добавляет информацию из xml в список с книгами
    private static void printInfoAboutAllChildNodes(NodeList nlist) {
        for (int i = 0; i < nlist.getLength(); i++) {
            Node node = nlist.item(i);

            if (node.getNodeType() == Node.TEXT_NODE) {   // У элементов есть два вида узлов - другие элементы или текстовая информация
                String textInformation = node.getNodeValue().replace("\n", "").trim();// Фильтрация информации, так как пробелы и переносы строчек нам не нужны. Это не информация.
                if (!textInformation.isEmpty()) {
                    //       System.out.println(node.getNodeValue()); // это содержание
                    switch (tag) {
                        case "title":
                            newBookFromXML.setTitle(node.getNodeValue());
                            break;
                        case "text":
                            newBookFromXML.setText(node.getNodeValue());
                            break;
                        case "genre":
                            newBookFromXML.setGenre(Genre.valueOf(node.getNodeValue().toUpperCase()));
                            break;
                        case "publishDate":
                            newBookFromXML.setPublishDate(node.getNodeValue());
                            Library.addBook(newBookFromXML);
                            break;
                        case "isbn":
                            newBookFromXML.setISBN(node.getNodeValue());
                            break;
                        default:
                            break;
                    }
                }
            } else {// Если это не текст, а элемент, то обрабатываем его как элемент.
                //     System.out.println("<" + node.getNodeName() + ">"); // это тег
                tag = node.getNodeName();
                NamedNodeMap attributes = node.getAttributes();// Получение атрибутов

                for (int k = 0; k < attributes.getLength(); k++) {// Вывод информации про все атрибуты
                    //   System.out.println("Имя атрибута: " + attributes.item(k).getNodeName() + ": " + attributes.item(k).getNodeValue());
                    newBookFromXML = new Book();
                    newBookFromXML.setISBN(attributes.item(k).getNodeValue());
                }
            }
            // Если у данного элемента еще остались узлы, то вывести всю информацию про все его узлы.
            if (node.hasChildNodes()) {
                printInfoAboutAllChildNodes(node.getChildNodes());
            }
        }
    }

}

