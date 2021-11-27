import java.util.List;

public class Rover {
    private Position position;
    private char direction;
    private String errorMessage;
    private final SpaceMap map;

    public Rover(int x, int y, char direction, SpaceMap map) {
        position = new Position(x, y);
        this.direction = direction;
        this.errorMessage = null;
        this.map = map;
    }

    public Position position() {
        return position;
    }

    public char direction() {
        return direction;
    }

    public void move(List<Character> commands) {
        for (Character command : commands) {
            switch (command) {
                case 'f' -> {
                    Position newPosition;
                    switch (direction) {
                        case 'E' -> newPosition = map.increaseX(position);
                        case 'W' -> newPosition = map.decreaseX(position);
                        case 'S' -> newPosition = map.decreaseY(position);
                        case 'N' -> newPosition = map.increaseY(position);
                        default -> throw new IllegalStateException("Unexpected value: " + direction);
                    }
                    if (map.hasObstacleAt(newPosition)) {
                        errorMessage = "Obstacle found at "+newPosition;
                    }
                    else {
                        position = newPosition;
                    }
                }
                case 'b' -> {
                    Position newPosition;
                    switch (direction) {
                        case 'E' -> newPosition = map.decreaseX(position);
                        case 'W' -> newPosition = map.increaseX(position);
                        case 'S' -> newPosition = map.increaseY(position);
                        case 'N' -> newPosition = map.decreaseY(position);
                        default -> throw new IllegalStateException("Unexpected value: " + direction);
                    }
                    if (map.hasObstacleAt(newPosition)) {
                        errorMessage = "Obstacle found at "+newPosition;
                    }
                    else {
                        position = newPosition;
                    }
                }
                case 'l' -> {
                    char newDirection;
                    switch (direction) {
                        case 'E' -> newDirection = 'N';
                        case 'W' -> newDirection = 'S';
                        case 'S' -> newDirection = 'E';
                        case 'N' -> newDirection = 'W';
                        default -> throw new IllegalStateException("Unexpected value: " + direction);
                    }
                    direction = newDirection;
                }
                case 'r' -> {
                    char newdirection;
                    switch (direction) {
                        case 'E' -> newdirection = 'S';
                        case 'W' -> newdirection = 'N';
                        case 'S' -> newdirection = 'W';
                        case 'N' -> newdirection = 'E';
                        default -> throw new IllegalStateException("Unexpected value: " + direction);
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
                "position=" + position +
                ", direction=" + direction +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
