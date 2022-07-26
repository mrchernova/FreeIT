package com.chernova.homework_7;
/*
 * Напишите три цикла выполняющих многократное сложение строк.
 * - с помощью оператора сложения и String
 * - с помощью append и StringBuilder
 * - с помощью append и StringBuffer
 */

public class Task21StringPerformanceAppraisal {
    public static void main(String[] args) {

        String s = "";
        StringBuilder sbl = new StringBuilder();
        StringBuffer sbf = new StringBuffer();
        Long ld1,ld2;

        ld1 = System.currentTimeMillis();
        for (int i = 0; i < 100000 ; i++) {
            s = s + i;
        }
        ld2 = System.currentTimeMillis();
        System.out.println("Скорость сложения строк с помощью + и String");
        System.out.println(ld2 + " - " + ld1 + " = " + (ld2-ld1) + " мс.");


        ld1 = System.currentTimeMillis();
        for (int i = 0; i < 100000 ; i++) {
            sbl.append(i);
        }
        ld2 = System.currentTimeMillis();
        System.out.println("Скорость сложения строк с помощью append и StringBuilder");
        System.out.println(ld2 + " - " + ld1 + " = " + (ld2-ld1) + " мс.");


        ld1 = System.currentTimeMillis();
        for (int i = 0; i < 100000 ; i++) {
            sbf.append(i);
        }
        ld2 = System.currentTimeMillis();
        System.out.println("Скорость сложения строк с помощью append и StringBuffer");
        System.out.println(ld2 + " - " + ld1 + " = " + (ld2-ld1) + " мс.");

    }
}

