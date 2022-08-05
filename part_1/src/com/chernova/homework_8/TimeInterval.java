package com.chernova.homework_8;

/**
 * Создать класс и объекты описывающие промежуток времени.
 * Сам промежуток в классе должен задаваться тремя свойствами: секундами, минутами, часами.
 * Сделать методы для получения полного количества секунд в объекте,
 * сравнения двух объектов (метод должен работать аналогично compareTo в строках).
 * Создать два конструктора: получающий общее количество секунд, и часы, минуты и секунды по отдельности.
 * Сделать метод для вывода данных.
 */

public class TimeInterval {
    public static void main(String[] args) {

        Time time_1 = new Time(120);
        Time time_2 = new Time(1, 30, 5);

        correctDate(time_1);
        System.out.println("time a:    " + time_1);
        correctDate(time_2);
        System.out.println("time b:    " + time_2);

        intoSeconds(time_1);
        System.out.println("\nseconds a: " + time_1);
        intoSeconds(time_2);
        System.out.println("seconds b: " + time_2);

        Time result = new Time(Math.abs(time_1.compareTo(time_2)));
        correctDate(result);
        System.out.println("\nTime interval between a and b = " + result);


    }

    // перевод каких бы то ни было введенных данных в нормальное представление часов, минут, секунд
    public static Time correctDate(Time time) {
        int seconds = time.seconds;
        time.seconds = seconds % 60;
        int minutes = ((seconds - time.seconds) / 60) + time.minutes;
        time.minutes = minutes % 60;
        time.hours = ((minutes - time.minutes) / 60) + time.hours;
        return time;
    }

    // метод для получения полного количества секунд в объекте
    public static int intoSeconds(Time time) {
        time.seconds = (time.seconds + time.minutes * 60 + time.hours * 3600);
        time.hours = 0;
        time.minutes = 0;
        return time.seconds;
    }


    private static class Time implements Comparable<Time> {
        private int hours;
        private int minutes;
        private int seconds;

        private Time(int hours, int minutes, int seconds) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        }

        public Time(int seconds) {
            this.hours = 0;
            this.minutes = 0;
            this.seconds = seconds;
        }

        @Override
        public String toString() {
            return hours + " h " +
                    minutes + " min " +
                    seconds + " sec";
        }

        @Override
        public int compareTo(Time time) {
            return this.seconds - time.seconds;
        }
    }
}
