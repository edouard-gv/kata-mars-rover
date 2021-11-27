import java.util.List;

public class Rover {
    private int x;
    private int y;
    private char direction;
    private String errorMessage;
    private SpaceMap map;

    public Rover(int x, int y, char direction, SpaceMap map) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.errorMessage = null;
        this.map = map;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public char direction() {
        return direction;
    }

    public void move(List<Character> commands) {
        for (Character command : commands) {
            switch (command) {
                case 'f':
                    switch (direction) {
                        case 'E' -> x++;
                        case 'W' -> x--;
                        case 'S' -> y--;
                        case 'N' -> y++;
                    }
                    if (x == 6) x=-5;
                    if (x == -6) x=5;
                    if (y == 6) y=-5;
                    if (y == -6) y=5;

                    break;
                case 'b':
                    switch (direction) {
                        case 'E' -> x--;
                        case 'W' -> x++;
                        case 'S' -> y++;
                        case 'N' -> y--;
                    }
                    if (x == 6) x=-5;
                    if (x == -6) x=5;
                    if (y == 6) y=-5;
                    if (y == -6) y=5;

                    break;
                case 'l': {
                    char newdirection = 'z';
                    switch (direction) {
                        case 'E' -> newdirection = 'N';
                        case 'W' -> newdirection = 'S';
                        case 'S' -> newdirection = 'E';
                        case 'N' -> newdirection = 'W';
                    }
                    direction = newdirection;
                    break;
                }
                case 'r': {
                    char newdirection = 'z';
                    switch (direction) {
                        case 'E' -> newdirection = 'S';
                        case 'W' -> newdirection = 'N';
                        case 'S' -> newdirection = 'W';
                        case 'N' -> newdirection = 'E';
                    }
                    direction = newdirection;
                    break;
                }
                default:
                    errorMessage = "Unknown command: " + command;
                    break;
            }
        }
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "Rover{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
