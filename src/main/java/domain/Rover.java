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
                    case f -> position = map.moveForward(position, direction);
                    case b -> position = map.moveForward(position, direction.invert());
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
