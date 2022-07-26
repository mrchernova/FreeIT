package com.chernova.homework_3;

/**
 * Написать программу, в которой в консоль будет выводится название месяца и сезон,
 * к которму этот месяц относится (написать с помощью  if  и с помощью switch)
 */

public class Task3 {
    public static void main(String[] args) {

        System.out.println("Введите номер месяца: ");
        int month = 11;
        System.out.println("Вы ввели " + month);

        switch (month) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
            default:
                System.out.println("Unknown month");
                break;
        }

        if (month == 12 || month == 1 || month == 2) {
            System.out.println("Winter season");
        } else if (month == 3 || month == 4 || month == 5) {
            System.out.println("Spring season");
        } else if (month == 6 || month == 7 || month == 8) {
            System.out.println("Summer season");
        } else if (month == 9 || month == 10 || month == 11) {
            System.out.println("Autumn season");
        } else System.out.println("Unknown season");
    }
}
