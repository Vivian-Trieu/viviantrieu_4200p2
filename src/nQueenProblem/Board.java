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
    
    public ArrayList<Board> getSuccessors() {
        ArrayList<Board> successors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int xInit = queens.get(i).getX();
            int yInit = queens.get(i).getY();
            // Get any successors in the NORTH direction 
            while (queens.get(i).moveUp(n) != Queen.STOP) {
                successors.add(this);
            }
            // Reset position
            queens.get(i).setX(xInit);
            queens.get(i).setY(yInit);

            // Get any successors in the SOUTH direction
            while (queens.get(i).moveDown(n) != Queen.STOP) {
                successors.add(this);
            }
            // Reset position
            queens.get(i).setX(xInit);
            queens.get(i).setY(yInit);

        }
        return successors;
    }
    
    public Board bestSuccessor() {
        ArrayList<Board> successors = getSuccessors();
        int numOfSuccessors= successors.size();
        ArrayList<Integer> bestSuccessors = new ArrayList<>();
        int minIndex;
        int minAttacks = n * n;
        int attacks;
        for (int i = 0; i < numOfSuccessors; i++) {
            attacks = successors.get(i).numOfAttacks();
            if (attacks < minAttacks) {}
        }
        return null;
    }

    private int numOfAttacks() {
        // Initialize and reset number of attacks possible in rows & diagonals
        int attacksInRows = 0;
        int[] queensByRow = new int[n];
        for (int i = 0; i < n; i++) {
            queensByRow[i] = 0;
        }

        int attacksInDiagonal = 0;
        int[] queensByDiag1 = new int[2 * n - 1];
        int[] queensByDiag2 = new int[2 * n - 1];
        for (int i = 0; i < 2 * n - 1; i++) {
            queensByDiag1[i] = 0;
            queensByDiag2[i] = 0;
        }

        // Count queens
        int x, y;
        for (int i = 0; i < n; i++) {
            x = queens.get(i).getX();
            y = queens.get(i).getY();
            queensByRow[x]++;
            queensByDiag1[x + y]++;
            queensByDiag2[n - 1 + y - x]++;
        }

        // Find attacks in rows
        for (int i = 0; i < n; i++) {
            if (queensByRow[i] > 1) {
                attacksInRows += queensByRow[i] - 1;
            }
        }

        // Find attacks in diagonal
        for (int i = 0; i < 2 * n - 1; i++) {
            if (queensByDiag1[i] > 1) {
                attacksInDiagonal += queensByDiag1[i] - 1;
            } 
            if (queensByDiag2[i] > 1) {
                attacksInDiagonal += queensByDiag2[i] - 1;
            }
        }

        // Find attacks in rows
        return attacksInDiagonal + attacksInRows;
    }
}
