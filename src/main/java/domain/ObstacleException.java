package domain;

public class ObstacleException extends Throwable {
    private Position position;

    public ObstacleException(Position position) {
        this.position = position;
    }

    public Position position() {
        return position;
    }
}
