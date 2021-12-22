/**
*Java_1_level_HomeWorkFour_TicTacToe
*
*@author Marina Bakhareva
*@version 18.12.2021
*/

import java.util.Random;
import java.util.Scanner;

class TicTacToe {

    final char SIGN_X = 'x';     //sign of human
    final char SIGN_O = 'o';     //sign of AI
    final char SIGN_EMPTY = '_'; //sign of empty cell
    final int SIZE = 3;          //sign of the game table
    final int WIN_SIZE = 3;      //sign of win-line
    final String MSG_FOR_HUMAN = "Enter x y [1...3]: ";
    final String MSG_YOU_WON = "YOU WON!";
    final String MSG_AI_WON = "AI WON!";
    final String MSG_DRAW = "Sorry, DRAW!";
    final String MSG_GAME_OVER = "GAME OVER";
    char[][] table;
    Scanner sc;
    Random random;
    
    public static void main(String[] args) {
        new TicTacToe().game(); 
    }
    
    TicTacToe() { 
        table = new char[SIZE][SIZE];
        sc = new Scanner(System.in);
        random = new Random();
    }
    
    void game() {
        initTable();
        printTable();
        while (true) {
            turnHuman();
            if (checkWin(SIGN_X)) {
                System.out.println(MSG_YOU_WON);
                break;
            }
            if (isTableFull()) {
                System.out.println(MSG_DRAW);
                break;
            }
            turnAi();
            printTable();
            if (checkWin(SIGN_O)) {
                System.out.println(MSG_AI_WON);
                break;
            }
            if (isTableFull()) {
                System.out.println(MSG_DRAW);
                break;
            }
        }
        printTable();
        System.out.println(MSG_GAME_OVER);
    }

    void initTable() { 
        for (int i = 0; i < SIZE; i++) 
            for (int j = 0; j < SIZE; j++) 
                table[i][j] = SIGN_EMPTY;
    }
    
    void printTable() { 
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(table[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    void turnHuman() { 
        int x, y;
        do {
            System.out.println(MSG_FOR_HUMAN);
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        table[x][y] = SIGN_X;
    }
    
    void turnAi() { 
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x, y));
        table[x][y] = SIGN_O;
    }
    
    boolean isCellValid(int x, int y) { 
        if (x < 0 || y < 0 || x > 2 || y > 2) {
            return false;
        }
        return table[x][y] == SIGN_EMPTY;
    }
    
    boolean checkWin(char ch) { 
        for (int i = 0; i < SIZE; i++) {
            if ((table[i][0] == ch && table[i][1] == ch && table[i][2] == ch) || (table[0][i] == ch && table[1][i] == ch && table[2][i] == ch))
                return true;
        }
        if ((table[0][0] == ch && table[1][1] == ch &&table[2][2] == ch) || 
            (table[2][0] == ch && table[1][1] == ch &&table[0][2] == ch)) {
            return true;
            }
        return false;
    }
    
    boolean isTableFull() { 
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (table[i][j] == SIGN_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}