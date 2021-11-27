public class SpaceMap {
    private final int size;

    public SpaceMap(int size) {
        this.size = size;
    }

    public int increase(int pos) {
        if (pos == size) return -size;
        return pos+1;
    }

    public int decrease(int pos) {
        if (pos == -size) return size;
        return pos-1;
    }
}
