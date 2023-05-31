package com.chernova.libraryXML;

public class Main {
    public static void main(String[] args) {

        // проверка xml на валидность.
        // Если успешно, то добавляет книги из xml в библиотеку
        // Если не успешно, программа продолжит работу без xml документа
        ValidatorXSD.validateXML();

        Menu.launchMenu();

    }
}

