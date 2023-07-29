package nQueenProblem;

import java.util.ArrayList;
import java.util.Arrays;
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

        // Fill board with 0's 
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '_');
        }

        
        // Fill board with queens
        for (Queen q : queens) {
            board[q.getX()][q.getY()] = 'Q';
        }
        

        for (char[] row : board) {
            System.out.println(printRow(row));;
        }
    }

    // Printer helper method
    private String printRow(char[] row) {
        StringBuilder sb = new StringBuilder();
        for (char c : row) {
            sb.append(c).append("  ");
        }
        return sb.toString().trim();
    }

    private void addQueen(Queen q) {
        if (queens.size() < n) {
            queens.add(q);
        }
    }
    /* 
    public ArrayList<Board> getSuccessors() {
        ArrayList<Board> successors = new ArrayList<>();
        for (int i = 0; i < n; i++) {

        }
        return successors;
    }
    */
}
