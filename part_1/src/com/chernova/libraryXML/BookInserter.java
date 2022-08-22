package com.chernova.libraryXML;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
public class BookInserter {

    public static void addNewBook(Document document) {

        Book newBook = new Book();
        newBook.setTitle("btbtbt");
        newBook.setText("new book Text");
        newBook.setPublishDate("1900-02-02");
        newBook.setISBN("0-0000-0000-0");

        Element book = document.createElement("book-book");

        Element title = document.createElement("Title-title");
        title.setTextContent(newBook.getTitle());

        Element text = document.createElement("Text");
        text.setTextContent(newBook.getText());

        Element date = document.createElement("Date");
      //  date.setTextContent(newBook.getDate());

        Element isbn = document.createElement("ISBN");
        isbn.setTextContent(newBook.getISBN());


        // Добавляем внутренние элементы книги в элемент <Book>
        book.appendChild(title);
        book.appendChild(text);
        book.appendChild(date);
        book.appendChild(isbn);

        Node root = document.getDocumentElement();
        // Добавляем книгу в корневой элемент
        root.appendChild(book);

        // Записываем XML в файл
        writeDocument(document);
    }

    private static void writeDocument(Document document) throws TransformerFactoryConfigurationError {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer tr = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            FileOutputStream fos = new FileOutputStream(ValidatorXSD.FILE_PATH + "listOfBooks.xml");
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
