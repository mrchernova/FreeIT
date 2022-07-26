package com.chernova.homework_3;

/**
 * Имеется прямоугольное отверстие размерами a и b, определить, можно ли его
 * полностью закрыть круглой картонкой радиусом r.
 */

public class ExtraTask5 {
    public static void main(String[] args) {

        float a = 4.3f;
        float b = 3.1f;
        float r = 2.3f;

        if (Math.pow(r, 2) >= Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2))) {
            System.out.println("possible to cover");
        } else {
            System.out.println("impossible to cover");
        }

    }
}
