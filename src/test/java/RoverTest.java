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

    private void assertRoverStatus(Rover rover, int expected_x, int expected_y, char expected_direction) {
        assertEquals(expected_x, rover.x());
        assertEquals(expected_y, rover.y());
        assertEquals(expected_direction, rover.direction());
    }

    @Test
    public void roverReceiveNoCommands() {
        Rover rover = new Rover(0, 0, 'N');
        rover.move(List.of());
        assertRoverStatus(rover, 0, 0, 'N');
    }

    @Test
    public void roverReceiveCommandToMoveForwardFacingNorth() {
        Rover rover = new Rover(0, 0, 'N');
        rover.move(List.of('f'));
        assertRoverStatus(rover, 0, 1, 'N');
    }

    @Test
    public void roverReceiveCommandToMoveForwardFacingEast() {
        Rover rover = new Rover(0, 0, 'E');
        rover.move(List.of('f'));
        assertRoverStatus(rover, 1, 0, 'E');
    }

    @Test
    public void roverReceiveCommandToMoveForwardFacingSouth() {
        Rover rover = new Rover(0, 0, 'S');
        rover.move(List.of('f'));
        assertRoverStatus(rover, 0, -1, 'S');
    }

    @Test
    public void roverReceiveCommandToMoveForwardFacingEastFromAnotherStartingPoint() {
        Rover rover = new Rover(1, 1, 'E');
        rover.move(List.of('f'));
        assertRoverStatus(rover, 2, 1, 'E');
    }

    @Test
    public void roverReceiveCommandToMoveForwardFacingWest() {
        Rover rover = new Rover(0, 0, 'W');
        rover.move(List.of('f'));
        assertRoverStatus(rover, -1, 0, 'W');
    }


}
