package com.chernova.homework_4;

import java.util.Scanner;

/**
 * Написать игру в которой нужно угадать случайно выбранную букву (именно букву).
 * При каждом вводе пользователем программа долна говорить "warmly, hot" или "chilly, cold"
 * в зависимости от того, как далеко буква пользователя от загаданной
 */

public class Task2 {
    public static void main(String[] args) {

        char hiddenLetter = 'a';
        char yourLetter;
        int differenceBetweenLetters;

        System.out.println("Try to found hidden letter");
        System.out.println("Enter a letter: ");
        Scanner scLetter = new Scanner(System.in);
        yourLetter = scLetter.next().charAt(0);


        while ((int) yourLetter != (int) hiddenLetter) {
            differenceBetweenLetters = Math.abs((int) yourLetter - (int) hiddenLetter);

            if (differenceBetweenLetters < 3) {
                System.out.println("hot");
                yourLetter = scLetter.next().charAt(0);
            } else if (differenceBetweenLetters >=3 && differenceBetweenLetters < 6){
                System.out.println("warmly");
                yourLetter = scLetter.next().charAt(0);
            }else if (differenceBetweenLetters >=6 && differenceBetweenLetters < 11){
                System.out.println("chilly");
                yourLetter = scLetter.next().charAt(0);
            }else{
                System.out.println("cold");
                yourLetter = scLetter.next().charAt(0);
            }
        }

        System.out.println("Congratulations! You found hidden letter");

    }
}
