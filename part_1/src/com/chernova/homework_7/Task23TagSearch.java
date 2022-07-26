package com.chernova.homework_7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Выполнить поиск в строке всех тегов абзацев,
 * в т.ч. у которых есть параметры
 * Например, <p id="p1">
 * Заменить их на пустые теги
 */

public class Task23TagSearch {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("<div>Дан текст: \n" +
                "<p>Aбзац 1. Какой-то там текст.</p> \n" +
                "<p id=\"p1\">Aбзац 2. Еще текст пусть будет.</p> \n" +
                "<p align=\"justify\">Абзац 3. Для примера еще строчка.</p> \n" +
                "</div>");

        System.out.println(s);

        Pattern p = Pattern.compile("<p(.*?)>");
        Matcher m = p.matcher(s);

        while (m.find()) {
            if (!m.group().equals("<p>")) {
                s.replace(m.start(), m.end(), "<p>");
                m.reset(s);
            }
        }
        System.out.println("\n" + s);

    }
}
