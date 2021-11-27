package domain;

import java.util.List;

public class Rover {
    private Position position;
    private Direction direction;
    private String errorMessage;
    private final SpaceMap map;

    public Rover(int x, int y, Direction direction, SpaceMap map) {
        position = new Position(x, y);
        this.direction = direction;
        this.errorMessage = null;
        this.map = map;
    }

    public Position position() {
        return position;
    }

    public Direction direction() {
        return direction;
    }

    public void move(String commands) {
        for (Character command : commands.toCharArray()) {
            try {
                switch (Command.valueOf(command.toString())) {
                    case f -> {
                        switch (direction) {
                            case E -> position = map.increaseX(position);
                            case W -> position = map.decreaseX(position);
                            case S -> position = map.decreaseY(position);
                            case N -> position = map.increaseY(position);
                            default -> throw new IllegalStateException("Unexpected value: " + direction);
                        }
                    }
                    case b -> {
                        switch (direction) {
                            case E -> position = map.decreaseX(position);
                            case W -> position = map.increaseX(position);
                            case S -> position = map.increaseY(position);
                            case N -> position = map.decreaseY(position);
                            default -> throw new IllegalStateException("Unexpected value: " + direction);
                        }
                    }
                    case l -> direction = direction.turnLeft();
                    case r -> direction = direction.turnRight();
                }
            } catch (ObstacleException obstacle) {
                errorMessage = "Obstacle found at " + obstacle.position();
            } catch (IllegalArgumentException iae) {
                errorMessage = "Unknown command: " + command;
                return;
            }
        }
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "domain.Rover{" +
                "position=" + position +
                ", direction=" + direction +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
