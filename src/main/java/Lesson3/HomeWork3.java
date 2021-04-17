package Lesson3;

/*
  * Домашнее задание к уроку №3
  * Тигашов Валерий
  *
  * ^^^ Проработать базовый искусственный интеллект, чтобы он мог блокировать ходы игрока. - Ну это слишьком для меня!)
  *
*/

import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {

    public static char[][] map;
    public static int sizeMapX;
    public static int sizeMapY;

    public static char player = 'x';
    public static char ai = 'o';
    public static char empty = ' ';

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random(); // [0;2)

    public static void creatMap(int sizeX, int sizeY) {
        sizeMapX = sizeX;
        sizeMapY = sizeY;
        map = new char[sizeMapY][sizeMapX];

        for (int y = 0; y < sizeMapY; y++) {
            for (int x = 0; x < sizeMapX; x++) {
                map[x][y] = empty;
            }
        }
    }

    public static void printMap() {
        System.out.println("-------------------");
        for (int y = 0; y < sizeMapY; y++) {
            for (int x = 0; x < sizeMapX; x++) {
                System.out.print(map[x][y] + " | ");
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }

    public static void turnPlayer() {
        int x;
        int y;

        do {
            System.out.print("Please, write your X: ");
            x = scanner.nextInt() -1;
            System.out.print("Please, write your Y: ");
            y = scanner.nextInt() -1;
        } while ( !validCell(x, y) || (!emptyCell(x, y) ));
        map[x][y] = player;
    }

    public static void turnAi() {
        int x;
        int y;

        do {
            x = random.nextInt(sizeMapX); // [0;3)
            y = random.nextInt(sizeMapY); // [0;3)
        } while ( !emptyCell(x, y) );
        map[x][y] = ai;
    }

    public static boolean validCell(int x, int y){
        return x >= 0 && x < sizeMapX && y >= 0 && y < sizeMapY;
    }
    public static boolean emptyCell(int x, int y){
        return map[x][y] == empty;
    }

    public static boolean checkWin(char player) {
        return checkDiag(player) || checkLine(player);
    }

    public static boolean checkDiag(char player) {
        boolean right, left;
        int j;
        int g;
        for (j = 0; j < 3; j++) {
            right = true;
            left = true;
            for (int i = 0; i < 4; i++) {
                switch (j) {
                    case 0:
                        right &= map[i][i] == player;
                        left &= map[4-i][i] == player;
                        break;
                    case 1:
                        right &= map[i+1][i] == player;
                        left &= map[4-i][i+1] == player;
                        break;
                    case 2:
                        right &= map[i][i+1] == player;
                        left &= map[4-1-i][i] == player;
                        break;
                }
            }
            if (right || left) return true;
        }
        for (g = 0; g < 3; g++) {
            right = true;
            left = true;
            for (int i = 4; i > 0; i--) {
                switch (g) {
                    case 0:
                        right &= map[i][i] == player;
                        left &= map[4-i][i] == player;
                        break;
                    case 1:
                        right &= map[i][i-1] == player;
                        left &= map[4-i][i-1] == player;
                        break;
                    case 2:
                        right &= map[i-1][i] == player;
                        left &= map[4-i+1][i] == player;
                        break;
                }
            }
            if (right || left) return true;
        }
        return false;
    }

    public static boolean checkLine(char player) {
        boolean cols, rows;
        for (int col = 0; col < 4; col++) {
            cols = true;
            rows = true;
            for (int row = 0; row < 4; row++) {
                cols &= (map[col][row] == player);
                rows &= (map[row][col] == player);
            }
            if (cols || rows) return true;
        }
        for (int col = 4; col > 0; col--) {
            cols = true;
            rows = true;
            for (int row = 4; row > 0; row--) {
                cols &= (map[col][row] == player);
                rows &= (map[row][col] == player);
            }
            if (cols || rows) return true;
        }
        return false;
    }



    public static boolean checkDraw() {
        for (int y = 0; y < sizeMapY; y++) {
            for (int x = 0; x < sizeMapX; x++) {
                if (map[y][x] == empty) {
                    return false;
                }
            }
        }
        return true;
    }

//*********************************************************************************************************************

    public static void main(String[] arg) {
        creatMap(5, 5 );
        printMap();

        while (true) {
            turnPlayer();
            printMap();
            if (checkWin(player)) {
                System.out.println("You Win!");
                break;
            }
            if (checkDraw()) {
                System.out.println("Draw!");
                break;
            }

            turnAi();
            printMap();
            if (checkWin(ai)) {
                System.out.println("AI Win!");
                break;
            }
            if (checkDraw()) {
                System.out.println("Draw!");
                break;
            }
        }
    }
}

