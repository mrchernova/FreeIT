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

        Time time1 = new Time(120);
        Time time2 = new Time(1, 30, 5);

        correctDate(time1);
        System.out.println("time a:    " + time1);
        correctDate(time2);
        System.out.println("time b:    " + time2);

        allTimeInSeconds(time1);
        System.out.println("\nseconds a: " + time1.allTimeInSeconds);
        allTimeInSeconds(time2);
        System.out.println("seconds b: " + time2.allTimeInSeconds);

        Time result = new Time(Math.abs(time1.compareTo(time2)));
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
    public static int allTimeInSeconds(Time time) {
        return time.allTimeInSeconds = (time.seconds + time.minutes * 60 + time.hours * 3600);
    }


    private static class Time implements Comparable<Time> {
        private int hours;
        private int minutes;
        private int seconds;
        private int allTimeInSeconds;

        private Time(int hours, int minutes, int seconds) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        }

        public Time(int seconds) {
            this.seconds = seconds;
        }

        @Override
        public String toString() {
            return hours + " h " + minutes + " min " + seconds + " sec";
        }

        @Override
        public int compareTo(Time time) {
            return this.allTimeInSeconds - time.allTimeInSeconds;
        }
    }
}
