package com.chernova.libraryXML;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorXSD {

    public static String tag = "";
    public static Book newBookFromXML;

    public static void validateXML() {
        boolean answer = ValidatorXSD.validateXMLSchema(Menu.FILE_PATH + "book.xsd", Menu.FILE_PATH + "book.xml");
        if (answer) {
            System.out.println("Файл book.xml соответствует схеме");
            try {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(Menu.FILE_PATH + "book.xml");

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
    }


    public static boolean validateXMLSchema(String xsdPath, String xmlPath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
        return true;
    }


    //добавляет информацию из xml в список с книгами
    private static void printInfoAboutAllChildNodes(NodeList nlist) {
        for (int i = 0; i < nlist.getLength(); i++) {
            Node node = nlist.item(i);

            if (node.getNodeType() == Node.TEXT_NODE) {   // У элементов есть два вида узлов - другие элементы или текстовая информация
                String textInformation = node.getNodeValue().replace("\n", "").trim();// Фильтрация информации, так как пробелы и переносы строчек нам не нужны. Это не информация.
                if (!textInformation.isEmpty()) {
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
                tag = node.getNodeName();
                NamedNodeMap attributes = node.getAttributes();// Получение атрибутов

                for (int k = 0; k < attributes.getLength(); k++) {// Вывод информации про все атрибуты
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