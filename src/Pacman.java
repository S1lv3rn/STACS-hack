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
        if (dir == 'a') {
            pacman = '>';
        } else if (dir == 'd') {
            pacman = '<';
        } else if (dir == 'w') {
            pacman = 'v';
        } else if (dir == 's') {
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

        if (dir == 'd') {
            if (board.canLeftRight(pac2.board[row][column+1])) {
                pac2.board[row][column] = original;
                column++;
                original = pac2.board[row][column];
                pacman = pacmanDirection(dir);
                pac2.board[row][column] = pacman;
            }
            else if((column + 1) > pac2.board.length){
                pac2.board[row][column] = original;
                column = 0;
                original = pac2.board[row][column];
                pacman = pacmanDirection(dir);
                pac2.board[row][column] = pacman;
            }
        } else if (dir == 'a') {
            if (board.canLeftRight(pac2.board[row][column-1])) {
                pac2.board[row][column] = original;
                column--;
                original = pac2.board[row][column];
                pacman = pacmanDirection(dir);
                pac2.board[row][column] = pacman;
            }
            else if((column - 1) == -1){
                pac2.board[row][column] = original;
                column = pac2.board.length;
                original = pac2.board[row][column];
                pac2.board[row][column] = original;
                column--;
                original = pac2.board[row][column];
                pacman = pacmanDirection(dir);
                pac2.board[row][column] = pacman;
            }
        } else if (dir == 'w') {
            if (board.canUpDown(pac2.board[row - 1][column])) {
                pac2.board[row][column] = original;
                row--;
                original = pac2.board[row][column];
                pacman = pacmanDirection(dir);
                pac2.board[row][column] = pacman;
            }
        }else if (dir == 's') {
            if (board.canUpDown(pac2.board[row + 1][column])) {
                pac2.board[row][column] = original;
                row++;
                original = pac2.board[row][column];
                pacman = pacmanDirection(dir);
                pac2.board[row][column] = pacman;
            }
        }
    }
}
