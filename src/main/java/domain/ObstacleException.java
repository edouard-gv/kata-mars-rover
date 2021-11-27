package domain;

public class ObstacleException extends Throwable {
    private final Position position;

    public ObstacleException(Position position) {
        this.position = position;
    }

    public Position position() {
        return position;
    }
}
