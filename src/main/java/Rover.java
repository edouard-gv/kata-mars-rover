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
            try {
                switch (command) {
                    case 'f' -> {
                        switch (direction) {
                            case 'E' -> position = map.increaseX(position);
                            case 'W' -> position = map.decreaseX(position);
                            case 'S' -> position = map.decreaseY(position);
                            case 'N' -> position = map.increaseY(position);
                            default -> throw new IllegalStateException("Unexpected value: " + direction);
                        }
                    }
                    case 'b' -> {
                        switch (direction) {
                            case 'E' -> position = map.decreaseX(position);
                            case 'W' -> position = map.increaseX(position);
                            case 'S' -> position = map.increaseY(position);
                            case 'N' -> position = map.decreaseY(position);
                            default -> throw new IllegalStateException("Unexpected value: " + direction);
                        }
                    }
                    case 'l' -> {
                        direction = Direction.valueOf(String.valueOf(direction)).turnLeft().toString().charAt(0);
                        /*switch (direction) {
                            case 'E' -> direction = 'N';
                            case 'W' -> direction = 'S';
                            case 'S' -> direction = 'E';
                            case 'N' -> direction = 'W';
                            default -> throw new IllegalStateException("Unexpected value: " + direction);
                        }*/
                    }
                    case 'r' -> {
                        switch (direction) {
                            case 'E' -> direction = 'S';
                            case 'W' -> direction = 'N';
                            case 'S' -> direction = 'W';
                            case 'N' -> direction = 'E';
                            default -> throw new IllegalStateException("Unexpected value: " + direction);
                        }
                    }
                    default -> errorMessage = "Unknown command: " + command;
                }
            } catch (ObstacleException obstacle) {
                errorMessage = "Obstacle found at " + obstacle.position();
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
