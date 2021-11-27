public class SpaceMap {
    private final int size;

    public SpaceMap(int size) {
        this.size = size;
    }

    public int putBack(int pos) {
        if (pos == size+1) return -size;
        if (pos == -size-1) return size;
        return pos;
    }

    public int increase(int pos) {
        return putBack(pos+1);
    }

    public int decrease(int pos) {
        return putBack(pos-1);
    }
}
