package domain;

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
                    case f -> position = goForward(direction);
                    case b -> position = goForward(direction.invert());
                    case l -> direction = direction.turnLeft();
                    case r -> direction = direction.turnRight();
                }
            } catch (ObstacleException obstacle) {
                errorMessage = "Obstacle found at " + obstacle.position();
                return;
            } catch (IllegalArgumentException iae) {
                errorMessage = "Unknown command: " + command;
                return;
            }
        }
    }

    private Position goForward(Direction direction) throws ObstacleException {
        switch (direction) {
            case E -> {
                return map.increaseX(position);
            }
            case W -> {
                return map.decreaseX(position);
            }
            case S -> {
                return map.decreaseY(position);
            }
            case N -> {
                return map.increaseY(position);
            }
            default -> throw new IllegalStateException("Unexpected value: " + this.direction);
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
