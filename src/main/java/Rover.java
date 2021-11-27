import java.util.List;

public class Rover {
    private int x;
    private int y;
    private char direction;
    private String errorMessage;

    public Rover(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.errorMessage = null;
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
            if (command == 'f') {
                switch (direction) {
                    case 'E' -> x++;
                    case 'W' -> x--;
                    case 'S' -> y--;
                    case 'N' -> y++;
                }
            }
            else if (command == 'b') {
                switch (direction) {
                    case 'E' -> x--;
                    case 'W' -> x++;
                    case 'S' -> y++;
                    case 'N' -> y--;
                }
            }
            else if (command == 'l') {
                char newdirection = 'z';
                switch (direction) {
                    case 'E' -> newdirection = 'N';
                    case 'W' -> newdirection = 'S';
                    case 'S' -> newdirection = 'E';
                    case 'N' -> newdirection = 'W';
                }
                direction = newdirection;
            }
            else if (command == 'r') {
                char newdirection = 'z';
                switch (direction) {
                    case 'E' -> newdirection = 'S';
                    case 'W' -> newdirection = 'N';
                    case 'S' -> newdirection = 'W';
                    case 'N' -> newdirection = 'E';
                }
                direction = newdirection;
            }
            else {
                errorMessage = "Unknown command: " + command;
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
