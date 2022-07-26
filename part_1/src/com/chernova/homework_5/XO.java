package com.chernova.homework_5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class XO {

    public static int n;
    public static int count;
    public static Scanner sc = new Scanner(System.in);
    public static String sx = "x";
    public static String so = "o";
    public static String[][] field = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};

    public static void main(String[] args) {

        int[][] exampleField = new int[3][3];
        printExample(exampleField);
        System.out.println("Start the game by selecting a cell 1..9");

        while (count < 9) {
            n = sc.nextInt();
            Step(n, field, sx);
            checkWinner();
            count++;

            if (count < 9) compStep(field);
            else {
                printField(field);
                System.out.println("Draw!");
                System.exit(0);
            }

            checkWinner();
            count++;
            printField(field);
        }
    }


    public static boolean checkWinner() {

        if ((field[0][0] + field[0][1] + field[0][2]).equals("xxx") ||
                (field[1][0] + field[1][1] + field[1][2]).equals("xxx") ||
                (field[2][0] + field[2][1] + field[2][2]).equals("xxx") ||
                (field[0][0] + field[1][0] + field[2][0]).equals("xxx") ||
                (field[0][1] + field[1][1] + field[2][1]).equals("xxx") ||
                (field[0][2] + field[1][2] + field[2][2]).equals("xxx") ||
                (field[0][0] + field[1][1] + field[2][2]).equals("xxx") ||
                (field[0][2] + field[1][1] + field[2][0]).equals("xxx")) {
            printField(field);
            System.out.println("You win!");
            System.exit(0);
            return true;
        } else if ((field[0][0] + field[0][1] + field[0][2]).equals("ooo") ||
                (field[1][0] + field[1][1] + field[1][2]).equals("ooo") ||
                (field[2][0] + field[2][1] + field[2][2]).equals("ooo") ||
                (field[0][0] + field[1][0] + field[2][0]).equals("ooo") ||
                (field[0][1] + field[1][1] + field[2][1]).equals("ooo") ||
                (field[0][2] + field[1][2] + field[2][2]).equals("ooo") ||
                (field[0][0] + field[1][1] + field[2][2]).equals("ooo") ||
                (field[0][2] + field[1][1] + field[2][0]).equals("ooo")) {
            printField(field);
            System.out.println("You lose!");
            System.exit(0);
            return true;
        } else {
            return false;
        }
    }


    public static void compStep(String[][] field) {
        Random randStep = new Random();
        n = randStep.nextInt(9) + 1; // [1..9]
        Step(n, field, so);
    }


    public static void Step(int n, String[][] field, String xo) {
        switch (n) {
            case 1:
                if (field[0][0].equals("-")) field[0][0] = xo;
                else checkStep(xo);
                break;
            case 2:
                if (field[0][1].equals("-")) field[0][1] = xo;
                else checkStep(xo);
                break;
            case 3:
                if (field[0][2].equals("-")) field[0][2] = xo;
                else checkStep(xo);
                break;
            case 4:
                if (field[1][0].equals("-")) field[1][0] = xo;
                else checkStep(xo);
                break;
            case 5:
                if (field[1][1].equals("-")) field[1][1] = xo;
                else checkStep(xo);
                break;
            case 6:
                if (field[1][2].equals("-")) field[1][2] = xo;
                else checkStep(xo);
                break;
            case 7:
                if (field[2][0].equals("-")) field[2][0] = xo;
                else checkStep(xo);
                break;
            case 8:
                if (field[2][1].equals("-")) field[2][1] = xo;
                else checkStep(xo);
                break;
            case 9:
                if (field[2][2].equals("-")) field[2][2] = xo;
                else checkStep(xo);
                break;
        }
    }

    public static void checkStep(String xo) {
        if (xo.equals("o")) compStep(field);
        else {
            System.out.println("Field is filled. Try again ");
            n = sc.nextInt();
            Step(n, field, sx);
        }
    }

    public static void printField(String[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(); //пробел между полями
    }

    public static void printExample(int[][] matrix) {
        int count = 0;
        System.out.println("|-----------|");
        System.out.println("|  EXAMPLE  |");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ++count;
                System.out.print("  " + matrix[i][j]);
                if (j == matrix.length - 1) System.out.print("  |");
            }
            System.out.println();
        }
        System.out.println("|-----------|");
    }
}
