package com.Work4;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PlayerChoice();

    }

    static void PlayerChoice () {
        char[][] map = createField(SIZE,DOT_EMPTY);
        prinMap(map);

        while (true) {
            enterH(DOT_X,map);
            prinMap(map);

            if (checkWin(map, DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (checkWin(map, DOT_O)) {
                System.out.println("Победили AI Apple");
                break;
            }
            /*if (checkWin(map, DOT_Y)) {
                System.out.println("Победили AI Apple");
                break;
            }*/
            if (isMapFull(map)) {
                System.out.println("Ничья");
                break;
            }


            enterR(DOT_O, map);
            //enterRY(DOT_Y, map);

        }




    }


    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
   // public static final char DOT_Y = 'Y';
    public static final int SIZE = 3;

    static char[][] createField (int SIZE, char DOT_EMPTY) { ;
        char[][] arr = new char[SIZE][SIZE];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = DOT_EMPTY;
            }
        }
        return arr;
    }

    static void enterH (char DOT_X, char[][] arr) {
        Scanner scanner = new Scanner(System.in);
        int X = 0,Y=0;

        System.out.println("Введите координаты X и Y");

        do {
            System.out.println("Кординаты X: ");
            X = scanner.nextInt()-1;
            System.out.println("Кординаты Y: ");
            Y = scanner.nextInt()-1;
        } while (!Ramki(SIZE,DOT_EMPTY, X, Y, arr));
        arr[X][Y] = DOT_X;
    }

    static boolean Ramki(int SIZE,char DOT_EMPTY, int X, int Y, char[][] arr) {
        if (X >= SIZE || X <0 || Y >= SIZE || Y <0) return false;
        if (arr[X][Y]==DOT_EMPTY) return true;
        return false;
    }

    static void enterR (char DOT_O, char[][] arr) {
        Random random = new Random();
        int X = 0,Y=0;
        do {
            X = random.nextInt(arr.length);
            Y = random.nextInt(arr.length);
        } while (!Ramki(SIZE,DOT_EMPTY, X, Y, arr));
        arr[X][Y] = DOT_O;
    }

    static void enterRY (char DOT_Y, char[][] arr) {
        Random random = new Random();
        int X = 0,Y=0;
        do {
            X = random.nextInt(arr.length);
            Y = random.nextInt(arr.length);
        } while (!Ramki(SIZE,DOT_EMPTY, X, Y, arr));
        arr[X][Y] = DOT_Y;
    }

    static void prinMap (char arr[][]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
                System.out.print(" ");
                //
            }
            System.out.println();
        }

    }


    public static boolean checkWin(char [][] arr,char symb) {
        int p = 0;


        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i==j&&arr[i][j]==symb) {
                    p++;

                }
            }
        }
        if (p==SIZE){
            return true;
        }
        else {
            p=0;
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i==SIZE-1-j&&arr[i][j]==symb) {
                    p++;

                }
            }
        }
        if (p==SIZE){
            return true;
        }
        else {
            p=0;
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ( i==SIZE-1 &&arr[i][j]==symb) {
                    p++;

                }
            }
        }
        if (p==SIZE){
            return true;
        }
        else {
            p=0;
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i==SIZE-SIZE&&arr[i][j]==symb) {
                    p++;

                }
            }
        }
        if (p==SIZE){
            return true;
        }
        else {
            p=0;
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (j==SIZE-1&&arr[i][j]==symb) {
                    p++;

                }
            }
        }
        if (p==SIZE){
            return true;
        }
        else {
            p=0;
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (j==SIZE-SIZE&&arr[i][j]==symb) {
                    p++;

                }
            }
        }
        if (p==SIZE){
            return true;
        }
        else {
            p=0;
        }

        return false;


    }


    public static boolean isMapFull(char [][] arr) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (arr[i][j] ==DOT_EMPTY) return false;
            }
        }
        return true;
    }

    }








