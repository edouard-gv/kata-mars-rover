public class SpaceMap {
    private final int size;

    public SpaceMap(int size) {
        this.size = size;
    }

    public int putBack(int pos) {
        int remainder = (pos + size) % (size*2+1);
        return (remainder < 0? remainder + size*2+1 - size: remainder - size);
    }
}
