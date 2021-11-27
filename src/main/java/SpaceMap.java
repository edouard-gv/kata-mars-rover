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

    public int increase(int pos) {
        if (pos == size) return -size;
        return pos+1;
    }

    public int decrease(int pos) {
        if (pos == -size) return size;
        return pos-1;
    }

    public boolean hasObstacleAt(int x, int y) {
        return obstacles.contains(new Position(x, y));
    }
}
