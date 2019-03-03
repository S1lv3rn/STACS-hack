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
        original = Pac2.board[row][column];
        Pac2.board[row][column] = pacman;
    }

    public void movePacman(char dir) {

        if (dir == 'd') {
            if (board.canLeftRight(Pac2.board[row][column+1])) {
                Pac2.board[row][column] = original;
                column++;
                original = Pac2.board[row][column];
                pacman = pacmanDirection(dir);
                Pac2.board[row][column] = pacman;
            }
            else if((column + 1) > Pac2.board.length){
                Pac2.board[row][column] = original;
                column = 0;
                original = Pac2.board[row][column];
                pacman = pacmanDirection(dir);
                Pac2.board[row][column] = pacman;
            }
        } else if (dir == 'a') {
            if (board.canLeftRight(Pac2.board[row][column-1])) {
                Pac2.board[row][column] = original;
                column--;
                original = Pac2.board[row][column];
                pacman = pacmanDirection(dir);
                Pac2.board[row][column] = pacman;
            }
            else if((column - 1) == -1){
                Pac2.board[row][column] = original;
                column = Pac2.board.length;
                original = Pac2.board[row][column];
                Pac2.board[row][column] = original;
                column--;
                original = Pac2.board[row][column];
                pacman = pacmanDirection(dir);
                Pac2.board[row][column] = pacman;
            }
        } else if (dir == 'w') {
            if (board.canUpDown(Pac2.board[row - 1][column])) {
                Pac2.board[row][column] = original;
                row--;
                original = Pac2.board[row][column];
                pacman = pacmanDirection(dir);
                Pac2.board[row][column] = pacman;
            }
        }else if (dir == 's') {
            if (board.canUpDown(Pac2.board[row + 1][column])) {
                Pac2.board[row][column] = original;
                row++;
                original = Pac2.board[row][column];
                pacman = pacmanDirection(dir);
                Pac2.board[row][column] = pacman;
            }
        }
    }
}
