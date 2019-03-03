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

        if (board.canUpDown(pac2.board[row - 1][column])) {
            pac2.board[row][column] = original;
            row--;
            original = pac2.board[row][column];
            pac2.board[row][column] = character;
        } else {
            pac2.board[row][column] = character;
        }

        System.out.println("up");
        return original;
    }

    public char moveDown(char character, char original) {
        if (board.canUpDown(pac2.board[row + 1][column])) {
            pac2.board[row][column] = original;
            row++;
            original = pac2.board[row][column];
            pac2.board[row][column] = character;
        } else {
            pac2.board[row][column] = character;
        }

        System.out.println("down");
        return original;
    }

    public char moveLeft(char character, char original) {
        if (board.canLeftRight(pac2.board[row][column - 1])) {
            pac2.board[row][column] = original;
            column--;
            original = pac2.board[row][column];
            pac2.board[row][column] = character;

        } else if (column == LEFTBORDER) {
            pac2.board[row][LEFTBORDER] = original;
            column = RIGHTBORDER;
            pac2.board[row][column] = original;
            column--;
            original = pac2.board[row][column];
            pac2.board[row][column] = character;

        } else {
            pac2.board[row][column] = character;
            return original;
        }

        System.out.println("left");

        return original;
    }

    public char moveRight(char character, char original) {
        System.out.println("COL: " + pac2.board[row].length);

        if (column + 1 == RIGHTBORDER) {
            System.out.println("COL: " + column);
            pac2.board[row][RIGHTBORDER] = original;
            System.out.println("nah");
            column = LEFTBORDER;
            System.out.println("hm");
            original = pac2.board[row][column];
            System.out.println("uh");
            pac2.board[row][column] = character;
            System.out.println("wju");
            return original;

        } else if (board.canLeftRight(pac2.board[row][column + 1])) {
            pac2.board[row][column] = original;
            column++;
            original = pac2.board[row][column];
            pac2.board[row][column] = character;

        } else {
            pac2.board[row][column] = character;
            return original;
        }

        return original;
    }
}
