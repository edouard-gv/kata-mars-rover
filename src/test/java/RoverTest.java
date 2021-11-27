import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
              y (N)

              A
              |
              |
(W) -x <----(0,0)-----> x (E)
              |
              |
              V

             -y (S)
**/

public class RoverTest {

    @Test
    public void roverReceiveNoCommands() {
        Rover rover = new Rover(0, 0, 'N');
        List<Character> commands = List.of(); //is immutable by construct
        rover.move(commands);
        assertEquals(0, rover.x());
        assertEquals(0, rover.y());
        assertEquals('N', rover.direction());
    }

    @Test
    public void roverReceiveCommandToMoveForwardFacingNorth() {
        Rover rover = new Rover(0, 0, 'N');
        List<Character> commands = List.of('f'); //is immutable by construct
        rover.move(commands);
        assertEquals(0, rover.x());
        assertEquals(1, rover.y());
        assertEquals('N', rover.direction());
    }

    @Test
    public void roverReceiveCommandToMoveForwardFacingEast() {
        Rover rover = new Rover(0, 0, 'E');
        List<Character> commands = List.of('f'); //is immutable by construct
        rover.move(commands);
        assertEquals(1, rover.x());
        assertEquals(0, rover.y());
        assertEquals('E', rover.direction());
    }


}
