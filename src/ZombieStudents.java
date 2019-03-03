import java.util.Random;

public class ZombieStudents {
    public char zombie;

    public int row;
    public int column;
    private char original;
    private final int LEFTBORDER = 0;
    private final int RIGHTBORDER = 27;

    public ZombieStudents(char zombie) {
        this.zombie = zombie;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void initzombie() {

    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void move() {
        Board board = new Board();
        Movement movement = new Movement(row, column);

        int rand = new Random().nextInt(2);

        if (board.canUpDown(pac2.board[row-1][column]) || board.canUpDown(pac2.board[row+1][column])) {
            if (rand == 0) {
                movement.moveUp(zombie, original);
            } else {
                movement.moveDown(zombie, original);
            }
        }
    }
}
