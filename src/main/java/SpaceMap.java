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

    public int increase(int coordinate) {
        if (coordinate == size) return -size;
        return coordinate+1;
    }

    public int decrease(int coordinate) {
        if (coordinate == -size) return size;
        return coordinate-1;
    }

    public boolean hasObstacleAt(Position position) {
        return obstacles.contains(position);
    }
}
