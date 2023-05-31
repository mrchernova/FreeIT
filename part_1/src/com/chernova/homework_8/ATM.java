package com.chernova.homework_8;

import java.util.Scanner;

/**
 * Создать класс и объекты описывающие Банкомат.
 * Набор купюр находящихся в банкомате должен задаваться тремя свойствами:
 * количеством купюр номиналом 20 50 100.
 * <p>
 * Сделать методы для добавления денег в банкомат.
 * Сделать функцию снимающую деньги.
 * <p>
 * На вход передается сумма денег.
 * На выход – булевское значение (операция удалась или нет).
 * <p>
 * При снятии денег функция должна рапечатывать каким количеством купюр какого номинала выдается сумма.
 * <p>
 * Создать конструктор с тремя параметрами – количеством купюр.
 */

public class ATM {

    public static Scanner sc = new Scanner(System.in);
    public static StringBuffer currency = new StringBuffer();

    public static void main(String[] args) {
        Money byn = new Money(1, 2, 3);

        int total = byn.cash100 * 100 + byn.cash50 * 50 + byn.cash20 * 20;
        System.out.println("Deposit money: " + total + " BYN");

        System.out.println(byn);

        int m = 0;  // сумма для снятия или пополнения
        boolean solution = true; // операция возможна или нет

        System.out.println("Do you want to withdraw from an ATM or deposit cash in an ATM?");
        System.out.println("w/d ?");
        String option = sc.nextLine();

        switch (option) {
            case "w":
                System.out.println("How much do you want to withdraw?");
                m = sc.nextInt();
                if (m <= total) {
                    int drop = 0;
                    withdraw(m, byn, drop, solution);
                } else {
                    System.out.println("Insufficient funds");
                }
                break;

            case "d":
                System.out.println("Deposit money: " + total + " BYN");
                System.out.println("How much do you want to deposit?");
                m = sc.nextInt();
                deposit(Math.abs(m), total, byn);
                break;
            default:
                System.out.println("Impossible option. Process finished");
        }
    }


    public static void deposit(int m, int total, Money byn) {

        if ((m == 10) | (m == 30) | (m % 10 > 0)) {
            System.out.println("You cannot deposit such sum. Process finished");
        } else {

            System.out.println("Количество купюр номиналом 100  BYN");
            int cash100 = Math.abs(sc.nextInt());
            System.out.println("Количество купюр номиналом 50  BYN");
            int cash50 = Math.abs(sc.nextInt());
            System.out.println("Количество купюр номиналом 20  BYN");
            int cash20 = Math.abs(sc.nextInt());

            if (m == (cash100 * 100 + cash50 * 50 + cash20 * 20)) {
                byn.cash100 += cash100;
                byn.cash50 += cash50;
                byn.cash20 += cash20;

                total += m;
                System.out.println("Deposit money: " + total + " BYN");
                System.out.println(byn);

            } else {
                System.out.println("Unable to perform operation. Process finished");
            }
        }
    }


    public static void withdraw(int m, Money byn, int drop, boolean solution) {
        int cash100 = byn.cash100;
        int cash50 = byn.cash50;
        int cash20 = byn.cash20;
        int mCopy = m; // так как 'm' в процессе будет изменятся, то делаем ее копию
        solution = true;

        if ((m < 20) | (m == 30) | (m % 10 > 0)) {
            solution = false;   // решений нет
        }

        // проходим по всем купюрам от большей к меньшей
        // если решения не будет найдено, отнимаем по одной купюре от 100 до 50 и повторяем решение
        if (cash100 - drop > 0) {
            while ((m >= 100) && (cash100 - drop > 0)) {
                cash100 = cash100 - drop;
                m -= 100;
                cash100--;
                currency.append(100 + " ");
            }
            while ((m >= 50) && (cash50 > 0)) {
                m -= 50;
                cash50--;
                currency.append(50 + " ");
            }
            while ((m >= 20) && (cash20 > 0)) {
                m -= 20;
                cash20--;
                currency.append(20 + " ");
            }

        } else if (cash50 - (drop - cash100) > 0) {
            while ((m >= 50) && (cash50 - (cash100 - drop) > 0)) {
                cash50 = cash50 - drop;
                m -= 50;
                cash50--;
                currency.append(50 + " ");
            }
            while ((m >= 20) && (cash20 > 0)) {
                m -= 20;
                cash20--;
                currency.append(20 + " ");
            }

        } else if (cash20 * 20 >= m) {
            while ((m >= 20) && (cash20 > 0)) {
                m -= 20;
                cash20--;
                currency.append(20 + " ");
            }
            // закончен перебор всех вариантов по порядку
            // если решений не найдено, то повторить цикл уменьшая только количество купюр по 50
        } else if (cash50 - (drop - (byn.cash50 + byn.cash100)) >= 0) { // имеет смысл делать проверку, если были купюры с номиналом 50
            while ((m >= 100) && (cash100 > 0)) {
                m -= 100;
                cash100--;
                currency.append(100 + " ");
            }

            if (cash50 - (drop - (byn.cash50 + byn.cash100)) > 0) {
                while ((m >= 50) && (cash50 > 0)) {
                    cash50 -= drop - (byn.cash50 + byn.cash100);
                    m -= 50;
                    cash50--;
                    currency.append(50 + " ");
                }
            }

            while ((m >= 20) && (cash20 > 0)) {
                m -= 20;
                cash20--;
                currency.append(20 + " ");
            }
        } else {
            // если ни один из вариантов не подошел
            solution = false; //решений нет
        }

        // если после всех действий m = 0, значит найдена подходящая комбинация купюр
        if (m == 0) {
            System.out.println("nominals: " + currency);

            // обновляем количество купюр в банкомате
            byn.cash100 = cash100;
            byn.cash50 = cash50;
            byn.cash20 = cash20;
            System.out.println(byn);

        } else {
            // если еще есть варианты, то повторить
            if (solution) {
                currency.delete(0, currency.length());
                drop++;
                withdraw(mCopy, byn, drop, solution);
            } else {
                System.out.println("You cannot withdraw such sum. Process finished");
            }
        }


    }


    private static class Money {
        private int cash100;
        private int cash50;
        private int cash20;

        private Money(int cash100, int cash50, int cash20) {
            this.cash100 = cash100;
            this.cash50 = cash50;
            this.cash20 = cash20;
        }

        @Override
        public String toString() {
            return "100 BYN * " + cash100 +
                    "\n50 BYN * " + cash50 +
                    "\n20 BYN * " + cash20;
        }
    }
}
