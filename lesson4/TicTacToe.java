/**
*Java_1_level_HomeWorkFour_TicTacToe
*
*@author Marina Bakhareva
*@version 18.12.2021
*/

import java.util.Random;
import java.util.Scanner;

class TicTacToe {
    final char SIGN_X = 'x'; //это константа и это поле
    final char SIGN_O = 'o';
    final char SIGN_EMPTY = '_';
    char[][] table;
    Scanner sc;
    Random random;
    
    public static void main(String[] args) {
        new TicTacToe().game(); //это особенный метод, который в ООП называется конструктор
    }
    
    TicTacToe() { 
        //конструктор: инициализация полей - имя конструктора должно совпадеть с именем класса
        table = new char[3][3];
        sc = new Scanner(System.in);
        random = new Random();
    }
    
    void game() {
        initTable();
        printTable();
        while (true) {
            turnHuman();
            if (isWin(SIGN_X)) {
                System.out.println("YOU WIN!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            turnAi();
            printTable();
            if (isWin(SIGN_O)) {
                System.out.println("AI WIN!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
        }
        printTable();
        System.out.println("GAME OVER");
    }

    void initTable() { //инициализция таблицы
        for (int y = 0; y < table.length; y++) 
            for (int x = 0; x < table.length; x++) 
                table[y][x] = SIGN_EMPTY;
    }
    
    void printTable() { //печать таблицы
        for (int y = 0; y < table.length; y++) {
            for (int x = 0; x < table.length; x++) {
                System.out.print(table[y][x] + "|");
            }
            System.out.println();
        }
    }
    
    void turnHuman() { //ход человека
        int x, y;
        do {
            System.out.println("Enter x y [1...3]: ");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        table[x][y] = SIGN_X;
    }
    
    void turnAi() { //ход компьютера
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x, y));
        table[x][y] = SIGN_O;
    }
    
    boolean isCellValid(int x, int y) { //валидна ли ячейка
        if (x < 0 || y < 0 || x > 2 || y > 2) {
            return false;
        }
        return table[x][y] == SIGN_EMPTY;
    }
    
    boolean isWin(char ch) { //проверка на победу
        //В ДЗ проверять только горизонталь и вертикаль через цикл 
        for (int i = 0; i < table.length; i++) {
            if ((table[i][0] == ch && table[i][1] == ch && table[i][2] == ch) || (table[0][i] == ch && table[1][i] == ch && table[2][i] == ch))
                return true;
            /*if ((table[0][0] == ch && table[1][1] == ch &&table[2][2] == ch) || (table[2][0] == ch && table[1][1] == ch &&table[0][2] == ch)) 
                return true; //проверка на диагональ */
        }
    return false;
    }
    
    boolean isTableFull() { //проверка на ничью
        for (int y = 0; y < table.length; y++) {
            for (int x = 0; x < table.length; x++) {
                if (table[y][x] == SIGN_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}