package com.malichenko.lesson5.dz;

public class Queens8 {

    public static void main(String[] args) {

        int size = 8;                                     // размер доски
        int[] queens= new int[size];                         // положение ферзей
        for(int q=0; q < size; q++)                       // бежим по колонкам
            queens[q] = 0;
    }



    private static boolean isPossible(int[][] desk, int x, int y) {
        return x >= 0 && x < desk.length &&
                y >= 0 && y < desk[0].length &&
                desk[x][y] == 0;
        //проверка на бой
    }

    private static int op = 0;
    private static boolean fMove(int[][] desk, int currX, int currY, int move) {
        desk[currX][currY] = move;
        if (move > desk.length * desk[0].length - 1) return true;

        int nextX, nextY;
        for (int i = 0; i < 7; i++) {
            op++;
           // nextX = currX + fMoves[i][1];
         //   nextY = currY + fMoves[i][0];
//            if (isPossible(desk, nextX, nextY) && fMove(desk, nextX, nextY, move + 1)) {
//                return true;
//            }
        }
        desk[currX][currY] = 0;
        return false;
    }

    private static void printDesk(int[][] desk) {
        for (int i = 0; i < desk.length; i++) {
            for (int j = 0; j < desk[0].length; j++) {
                System.out.printf("%3d", desk[i][j]);
            }
            System.out.println();
        }
    }
}
