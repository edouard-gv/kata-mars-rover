package domain;

import java.util.List;

public class SpaceMap {
    private final int size;
    private final List<Position> obstacles;

    public SpaceMap(int size) {
        this.size = size;
        this.obstacles = List.of();
    }

    public SpaceMap(int size, List<Position> obstacles) {
        this.size = size;
        this.obstacles = obstacles;
    }

    private int increase(int coordinate) {
        return coordinate == size ? -size : coordinate + 1;
    }

    private int decrease(int coordinate) {
        return coordinate == -size ? size : coordinate - 1;
    }

    private boolean checkPosition(Position position) {
        return !obstacles.contains(position);
    }

    private Position increaseX(Position position) {
        return new Position(increase(position.x()), position.y());
    }

    private Position decreaseX(Position position) {
        return new Position(decrease(position.x()), position.y());
    }

    private Position increaseY(Position position) {
        return new Position(position.x(), increase(position.y()));
    }

    private Position decreaseY(Position position) {
        return new Position(position.x(), decrease(position.y()));
    }

    Position moveForward(Position position, Direction direction) throws ObstacleException {
        Position newPosition;
        switch (direction) {
            case E -> newPosition = increaseX(position);
            case W -> newPosition =  decreaseX(position);
            case S -> newPosition =  decreaseY(position);
            case N -> newPosition =  increaseY(position);
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        }
        if (!checkPosition(newPosition)) {
            throw new ObstacleException(newPosition);
        }
        return newPosition;
    }
}
