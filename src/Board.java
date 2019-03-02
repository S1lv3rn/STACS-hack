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


}
