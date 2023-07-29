package nQueenProblem;

import java.util.ArrayList;
import java.util.Random;

public class Board {
    private int n = 8; // dimensions of board
    private ArrayList<Queen> queens;

    // Constructor for Board
    public Board() {
        queens = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            Queen q = new Queen(r.nextInt(n), i);
            addQueen(q);
        }
    }

    public void printBoard() {
        char[][] board = new char[n][n];

        // fill board with 0's 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '0';
            }
        }

        // add queens to board
        for (Queen q : queens) {
            board[q.getX()][q.getY()] = '1';
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(board[i][j]);
                if (j == 7) {
                    System.out.println();
                } else {
                    System.out.println(" ");
                }
            }
        }
    }

    private void addQueen(Queen q) {

    }
}
