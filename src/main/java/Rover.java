import java.util.List;

public class Rover {
    private int x;
    private int y;
    private char direction;

    public Rover(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public char direction() {
        return direction;
    }

    public void move(List<Character> commands) {
        for (Character command : commands) {
            if (direction == 'E') {
                x++;
            }
            else if (direction == 'W') {
                x--;
            }
            else if (direction == 'S') {
                y--;
            }
            else {
                y++;
            }
        }


    }
}
