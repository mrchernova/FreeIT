package com.chernova.homework_5;

/**
 * Создать двухмерный квадратный массив, и заполнить его «бабочкой», т.е
 * таким образом:
 * 1 1 1 1 1
 * 0 1 1 1 0
 * 0 0 1 0 0
 * 0 1 1 1 0
 * 1 1 1 1 1
 */

public class Task17 {
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        int k = 0;

        for (int i = 0; i < matrix.length; i++) {

            // середина матрицы
            if (i == matrix.length / 2) {
                for (int j = i; j < matrix.length - i; j++) matrix[i][j] = 1;

                // первая половина матрицы
            } else if (i < matrix.length / 2) {
                k = i;
                for (int j = i; j < matrix.length - i; j++) matrix[i][j] = 1;

                // вторая половины матрицы
            } else {
                for (int j = k; j < matrix.length - k; j++) matrix[i][j] = 1;
                k--;
            }
        }

        // вывод матрицы
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();

        }
    }
}
