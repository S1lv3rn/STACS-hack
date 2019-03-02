public class Pacman {

    public static char pacman = '<';

    public static int points = 0;

    private int row = 26;
    private int column = 13;

    Board board = new Board();

    public static int addPoints() {
        points++;
        return points;
    }

    public char pacmanDirection(char dir) {
        if (dir == 'l') {
            pacman = '>';
        } else if (dir == 'r') {
            pacman = '<';
        } else if (dir == 'u') {
            pacman = 'v';
        } else if (dir == 'd') {
            pacman = '∧';
        }

        return pacman;
    }

    private char original;
    public void initPacman() {
        original = pac2.board[row][column];
        pac2.board[row][column] = pacman;
    }

    public void movePacman(char dir) {
        if (dir == 'r') {
            if (board.canLeftRight(pac2.board[row+1][column+1])) {
                pac2.board[row][column] = original;
                row++;
                column++;
                original = pac2.board[row][column];
                pac2.board[row][column] = pacman;
            }
        } else if (dir == 'l') {
            if (board.canLeftRight(pac2.board[row-1][column-1])) {
                pac2.board[row][column] = original;
                row--;
                column--;
                original = pac2.board[row][column];
                pac2.board[row][column] = pacman;
            }
        }
    }
}
