public class Movement {

    private Board board = new Board();
    private int row;
    private int column;

    private final int LEFTBORDER = 0;
    private final int RIGHTBORDER = 27;
    public Movement(int row, int column) {
        this.column = column;
        this.row = row;
    }

    public char moveUp(char character, char original) {

        if (board.canUpDown(Pac2.board[row - 1][column])) {
            Pac2.board[row][column] = original;
            row--;
            original = Pac2.board[row][column];
            Pac2.board[row][column] = character;
        }
//        else {
//            Pac2.board[row][column] = character;
//        }

        System.out.println("up");
        return original;
    }

    public char moveDown(char character, char original) {
        if (board.canUpDown(Pac2.board[row + 1][column])) {
            Pac2.board[row][column] = original;
            row++;
            original = Pac2.board[row][column];
            Pac2.board[row][column] = character;
        }
//        else {
//            Pac2.board[row][column] = character;
//        }

        System.out.println("down");
        return original;
    }

    public char moveLeft(char character, char original) {
        if (board.canLeftRight(Pac2.board[row][column - 1])) {
            Pac2.board[row][column] = original;
            column--;
            original = Pac2.board[row][column];
            Pac2.board[row][column] = character;

        } else if (column == LEFTBORDER) {
            Pac2.board[row][LEFTBORDER] = original;
            column = RIGHTBORDER;
            Pac2.board[row][column] = original;
            column--;
            original = Pac2.board[row][column];
            Pac2.board[row][column] = character;

        }
//        else {
//            Pac2.board[row][column] = character;
//            return original;
//        }

        System.out.println("left");

        return original;
    }

    public char moveRight(char character, char original) {

        if (column + 1 == RIGHTBORDER) {
            Pac2.board[row][RIGHTBORDER] = original;
            column = LEFTBORDER;
            original = Pac2.board[row][column];
            Pac2.board[row][column] = character;
            return original;

        } else if (board.canLeftRight(Pac2.board[row][column + 1])) {
            Pac2.board[row][column] = original;
            column++;
            original = Pac2.board[row][column];
            Pac2.board[row][column] = character;

        }
//        else {
//            Pac2.board[row][column] = character;
//            return original;
//        }

        return original;
    }
}
