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

    public Position checkPosition(Position position) throws ObstacleException {
        if (obstacles.contains(position)) {
            throw new ObstacleException(position);
        }
        return position;
    }

    public Position increaseX(Position position) throws ObstacleException {
        return checkPosition(new Position(increase(position.x()), position.y()));
    }

    public Position decreaseX(Position position) throws ObstacleException {
        return checkPosition(new Position(decrease(position.x()), position.y()));
    }

    public Position increaseY(Position position) throws ObstacleException {
        return checkPosition(new Position(position.x(), increase(position.y())));
    }

    public Position decreaseY(Position position) throws ObstacleException {
        return checkPosition(new Position(position.x(), decrease(position.y())));
    }
}