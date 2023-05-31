package com.chernova.libraryXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Library {

    public static LinkedList<Book> list = new LinkedList<>();
    public static int id = 0;

    //получить все книги (метод ВОЗВРАЩАЕТ список всех книг в библиотеке)
    public static LinkedList<Book> getAllBooks() {
        return list;
    }


    //  добавить книгу (принимает объект книги и добавляет его в список товаров)
    public static void addBook(Book book) {
        book.setLocalDate(new Date());
        list.add(book);
    }


    //редактировать книгу (принимает объект книги)
    public static void editBook(Book book) {
        System.out.print("Выбранная книга:");
        System.out.println(book);

        System.out.println("Изменить название книги: ");
        System.out.println("(оставьте поле пустым, если не хотите его менять)");
        Menu.sc.nextLine();
        String title = Menu.sc.nextLine();
        if (!title.trim().isEmpty()) {
            book.setTitle(title);
        }

        System.out.println("Изменить содержание книги: ");
        System.out.println("(оставьте поле пустым, если не хотите его менять)");
        String text = Menu.sc.nextLine();
        if (!text.trim().isEmpty()) {
            book.setText(text);
        }

        System.out.println("Изменить жанр книги: ");
        System.out.println(Menu.ANSI_YELLOW);
        Genre.printGenre();
        System.out.println(Menu.ANSI_RESET);
        boolean readyToSet = false;
        while (!readyToSet) {
            try {
                readyToSet = true;
                int genreAdd = Menu.sc.nextInt();
                book.setGenre(Genre.values()[genreAdd - 1]);
            } catch (InputMismatchException e) {
                System.out.println("Введите номер жанра");
                readyToSet = false;
                Menu.sc.next();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Выберите жанр из списка");
                readyToSet = false;
            }
        }

        System.out.println("Изменить ISBN в формате: х-хххх-хххх-х ");
        System.out.println("(оставьте поле пустым, если не хотите его менять)");
        Menu.sc.nextLine();
        String inputISBN = Menu.sc.nextLine();
        if (!inputISBN.trim().isEmpty()) {
            boolean check = false;
            while (!check) {
                if (inputISBN.matches("[0-9]-[0-9]{4}-[0-9]{4}-[0-9]")) {
                    check = true;
                } else {
                    System.out.println("Введенный isbn  не соответствует формату. Попробуйте еще раз ");
                    inputISBN = Menu.sc.nextLine();
                }
            }
            book.setISBN(inputISBN);
        }

        System.out.println("Изменить дату публикации в формате: yyyy-MM-dd ");
        System.out.println("(оставьте поле пустым, если не хотите его менять)");
        String publishDate = Menu.sc.nextLine();
        if (!publishDate.trim().isEmpty()) {
            boolean check = false;
            while (!check) {
                if (publishDate.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
                    check = true;
                } else {
                    System.out.println("Введенная дата не соответствует формату. Попробуйте еще раз ");
                    publishDate = Menu.sc.nextLine();
                }
            }
            book.setPublishDate(publishDate);
        }

        book.setLocalDate(new Date()); //дата изменения книги
        System.out.println(Menu.ANSI_GREEN + "Данные изменены" + Menu.ANSI_RESET);
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
            System.out.println(Menu.ANSI_GREEN + "Книга успешно удалена" + Menu.ANSI_RESET);
        } else {
            System.out.println(Menu.ANSI_RED + "Книги с таким id нет в списке" + Menu.ANSI_RESET);
        }
    }


    public static void addBooksToXML() {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // создает корневой элемент
            Element root = document.createElement("books");
            document.appendChild(root);


            for (int i = 0; i < list.size(); i++) {

                Element book = document.createElement("book");

                Element title = document.createElement("title");
                title.setTextContent(list.get(i).getTitle());

                Element text = document.createElement("text");
                text.setTextContent(list.get(i).getText());

                Element genre = document.createElement("genre");
                genre.setTextContent(list.get(i).getGenre().value);

                Element publishDate = document.createElement("publishDate");
                publishDate.setTextContent(list.get(i).getPublishDate());

                Element isbn = document.createElement("ISBN");
                isbn.setTextContent(list.get(i).getISBN());

                // Добавляет внутренние элементы книги в элемент <Book>
                book.appendChild(title);
                book.appendChild(text);
                book.appendChild(genre);
                book.appendChild(publishDate);
                book.setAttribute("isbn", list.get(i).getISBN());

//            // Добавляет книгу в корневой элемент
                root.appendChild(book);
                // Записывает XML в файл
                writeDocument(document);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void writeDocument(Document document) throws TransformerFactoryConfigurationError {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer tr = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            FileOutputStream fos = new FileOutputStream(Menu.FILE_PATH + "book.xml");
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);
        }
    }
}









