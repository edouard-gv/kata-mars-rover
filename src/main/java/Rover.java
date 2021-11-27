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
                case 'f' -> {
                    int new_y = y;
                    switch (direction) {
                        case 'E' -> x = map.increase(x);
                        case 'W' -> x = map.decrease(x);
                        case 'S' -> new_y = map.decrease(y);
                        case 'N' -> new_y = map.increase(y);
                    }
                    if (map.hasObstacleAt(x, new_y)) {
                        errorMessage = "Obstacle found at "+x+","+new_y;
                    }
                    else {
                        y = new_y;
                    }
                }
                case 'b' -> {
                    switch (direction) {
                        case 'E' -> x = map.decrease(x);
                        case 'W' -> x = map.increase(x);
                        case 'S' -> y = map.increase(y);
                        case 'N' -> y = map.decrease(y);
                    }
                }
                case 'l' -> {
                    char newdirection = 'z';
                    switch (direction) {
                        case 'E' -> newdirection = 'N';
                        case 'W' -> newdirection = 'S';
                        case 'S' -> newdirection = 'E';
                        case 'N' -> newdirection = 'W';
                    }
                    direction = newdirection;
                }
                case 'r' -> {
                    char newdirection = 'z';
                    switch (direction) {
                        case 'E' -> newdirection = 'S';
                        case 'W' -> newdirection = 'N';
                        case 'S' -> newdirection = 'W';
                        case 'N' -> newdirection = 'E';
                    }
                    direction = newdirection;
                }
                default -> errorMessage = "Unknown command: " + command;
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
