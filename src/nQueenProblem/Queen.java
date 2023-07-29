package nQueenProblem;

public class Queen {

    private int x;
    private int y;

    public Queen(int x_coord, int y_coord) {
        x = x_coord;
        y = y_coord;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int y_coord) {
        y = y_coord;
    }

    public void setX(int x_coord) {
        x = x_coord;
    }

    public int moveUp (int n) {
        if (x > 0) {
            x--;
            return 0;
        }
        return 1;
    }

    public int moveDown (int n) {
        if (x < n - 1) {
            x++;
            return 0;
        }
        return 1;
    }
}
