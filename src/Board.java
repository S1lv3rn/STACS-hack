import java.io.BufferedReader;
import java.io.FileReader;

public class Board {
    private final static char wall = '0';
    private final static char horizontal = '-';
    private final static char vertical = '|';
    private final static char intersection = '+';

    private char type;

    public char getBlock (char nextBlock) {
        switch (nextBlock) {
            case wall: return wall;
            case horizontal: return horizontal;
            case vertical: return vertical;
            case intersection: return intersection;
            default: return horizontal;
        }
    }

    public boolean canLeftRight(char nextBlock) {
        switch (nextBlock) {
            case wall :
                System.out.println("You can't go this way");
                return false;
            case horizontal :
                System.out.println("ok");
                return true;
            case vertical :
                System.out.println("You can only go up or down");
                return false;
            case intersection :
                System.out.println("cmon in");
                return true;
            default:
                System.out.println(":v");
                return false;
        }
    }

    public boolean canUpDown(char nextBlock) {
        switch (nextBlock) {
            case wall : return false;
            case horizontal : return false;
            default: return true;
        }
    }
}
