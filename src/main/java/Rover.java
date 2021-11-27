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
                    int newX = x;
                    int newY = y;
                    switch (direction) {
                        case 'E' -> newX = map.increase(x);
                        case 'W' -> newX = map.decrease(x);
                        case 'S' -> newY = map.decrease(y);
                        case 'N' -> newY = map.increase(y);
                    }
                    if (map.hasObstacleAt(new Position(newX, newY))) {
                        errorMessage = "Obstacle found at "+newX+","+newY;
                    }
                    else {
                        x = newX;
                        y = newY;
                    }
                }
                case 'b' -> {
                    int newX = x;
                    int newY = y;
                    switch (direction) {
                        case 'E' -> newX = map.decrease(x);
                        case 'W' -> newX = map.increase(x);
                        case 'S' -> newY = map.increase(y);
                        case 'N' -> newY = map.decrease(y);
                    }
                    if (map.hasObstacleAt(new Position(newX, newY))) {
                        errorMessage = "Obstacle found at "+newX+","+newY;
                    }
                    else {
                        x = newX;
                        y = newY;
                    }
                }
                case 'l' -> {
                    char newDirection = 'z';
                    switch (direction) {
                        case 'E' -> newDirection = 'N';
                        case 'W' -> newDirection = 'S';
                        case 'S' -> newDirection = 'E';
                        case 'N' -> newDirection = 'W';
                    }
                    direction = newDirection;
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
