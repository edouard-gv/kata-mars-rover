package domain;

public enum Direction {
    N, E, S, W;

    public Direction invert() {
        return Direction.values()[(ordinal()+2) % 4];
    }

    public Direction turnRight() {
        return Direction.values()[(ordinal()+1) % 4];
    }

    public Direction turnLeft() {
        return Direction.values()[(ordinal()+3) % 4];
    }

}
