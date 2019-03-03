public class Pacman {

    public static int row = 26;
    public static int column = 13;
    public char character;
    public static int points = 0;
    private final int LEFTBORDER = 0;
    private final int RIGHTBORDER = 27;
    private char original;

    public int addPoints() {
        points++;
        return points;
    }

    public char characterDirection(char dir) {
        if (dir == 'a') {
            character = '>';
        } else if (dir == 'd') {
            character = '<';
        } else if (dir == 'w') {
            character = 'v';
        } else if (dir == 's') {
            character = '∧';
        }

        return character;
    }

    public void initcharacter() {
        character = '<';
        original = Pac2.board[row][column];
        Pac2.board[row][column] = character;
    }

    public void moveCharacter(char dir) {
        Movement movement = new Movement(row, column);

        character = characterDirection(dir);
        if (dir == 'd') {
            original = movement.moveRight(character, original);
            column++;
            if (column == RIGHTBORDER) {
                column = 0;
            }
        } else if (dir == 'a') {
            original = movement.moveLeft(character, original);
            column--;
            if (column == LEFTBORDER) {
                column = Pac2.board[row].length - 1;
            }
        } else if (dir == 'w') {
            original = movement.moveUp(character, original);
            row--;
        }else if (dir == 's') {
            original = movement.moveDown(character, original);
            row++;
        }

        System.out.println(original);
    }
}
