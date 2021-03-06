package domain.test;

import domain.Rover;
import org.junit.jupiter.api.Test;

import static domain.Direction.*;

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

public class CommandTest extends RoverTest {

    @Test
    public void roverReceiveNoCommands() {
        Rover rover = new Rover(0, 0, N, defaultMap);
        rover.move("");
        assertRoverStatus(rover, 0, 0, N);
    }

    @Test
    public void roverReceiveCommandToMoveForwardFacingNorth() {
        Rover rover = new Rover(0, 0, N, defaultMap);
        rover.move("f");
        assertRoverStatus(rover, 0, 1, N);
    }

    @Test
    public void roverReceiveCommandToMoveForwardFacingEast() {
        Rover rover = new Rover(0, 0, E, defaultMap);
        rover.move("f");
        assertRoverStatus(rover, 1, 0, E);
    }

    @Test
    public void roverReceiveCommandToMoveForwardFacingSouth() {
        Rover rover = new Rover(0, 0, S, defaultMap);
        rover.move("f");
        assertRoverStatus(rover, 0, -1, S);
    }

    @Test
    public void roverReceiveCommandToMoveForwardFacingEastFromAnotherStartingPoint() {
        Rover rover = new Rover(1, 1, E, defaultMap);
        rover.move("f");
        assertRoverStatus(rover, 2, 1, E);
    }

    @Test
    public void roverReceiveCommandToMoveForwardFacingWest() {
        Rover rover = new Rover(0, 0, W, defaultMap);
        rover.move("f");
        assertRoverStatus(rover, -1, 0, W);
    }

    @Test
    public void roverReceivesTwoCommandsToMoveForwardFacingWest() {
        Rover rover = new Rover(0, 0, W, defaultMap);
        rover.move("ff");
        assertRoverStatus(rover, -2, 0, W);
    }

    @Test
    public void roverReceiveCommandToMoveBackwardFacingNorth() {
        Rover rover = new Rover(0, 0, N, defaultMap);
        rover.move("b");
        assertRoverStatus(rover, 0, -1, N);
    }

    @Test
    public void roverReceiveCommandToMoveBackwardFacingEast() {
        Rover rover = new Rover(0, 0, E, defaultMap);
        rover.move("b");
        assertRoverStatus(rover, -1, 0, E);
    }

    @Test
    public void roverReceiveCommandToMoveBackwardFacingSouth() {
        Rover rover = new Rover(0, 0, S, defaultMap);
        rover.move("b");
        assertRoverStatus(rover, 0, 1, S);
    }

    @Test
    public void roverReceiveCommandToMoveBackwardFacingWest() {
        Rover rover = new Rover(0, 0, W, defaultMap);
        rover.move("b");
        assertRoverStatus(rover, 1, 0, W);
    }

    @Test
    public void roverReceiveCommandToTurnLeftFacingNorth() {
        Rover rover = new Rover(0, 0, N, defaultMap);
        rover.move("l");
        assertRoverStatus(rover, 0, 0, W);
    }

    @Test
    public void roverReceiveCommandToTurnLeftFacingSouth() {
        Rover rover = new Rover(0, 0, S, defaultMap);
        rover.move("l");
        assertRoverStatus(rover, 0, 0, E);
    }

    @Test
    public void roverReceiveCommandToTurnLeftFacingEast() {
        Rover rover = new Rover(0, 0, E, defaultMap);
        rover.move("l");
        assertRoverStatus(rover, 0, 0, N);

    }

    @Test
    public void roverReceiveCommandToTurnLeftFacingWest() {
        Rover rover = new Rover(0, 0, W, defaultMap);
        rover.move("l");
        assertRoverStatus(rover, 0, 0, S);
    }

    @Test
    public void roverReceiveCommandToTurnRightFacingNorth() {
        Rover rover = new Rover(0, 0, N, defaultMap);
        rover.move("r");
        assertRoverStatus(rover, 0, 0, E);
    }

    @Test
    public void roverReceiveCommandToTurnRightFacingSouth() {
        Rover rover = new Rover(0, 0, S, defaultMap);
        rover.move("r");
        assertRoverStatus(rover, 0, 0, W);
    }

    @Test
    public void roverReceiveCommandToTurnRightFacingEast() {
        Rover rover = new Rover(0, 0, E, defaultMap);
        rover.move("r");
        assertRoverStatus(rover, 0, 0, S);
    }

    @Test
    public void roverReceiveCommandToTurnRightFacingWest() {
        Rover rover = new Rover(0, 0, W, defaultMap);
        rover.move("r");
        assertRoverStatus(rover, 0, 0, N);
    }
}
