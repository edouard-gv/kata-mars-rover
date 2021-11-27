package domain.test;

import java.util.List;

import domain.Rover;
import org.junit.jupiter.api.Test;

import static domain.Direction.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class CommandErrorsTest extends RoverTest {


    @Test
    public void roverReceiveCorrectCommand() {
        Rover rover = new Rover(0, 0, N, defaultMap);
        rover.move("f");
        assertNull(rover.getErrorMessage());
    }

    @Test
    public void roverReceivesUnknownCommand() {
        Rover rover = new Rover(0, 0, W, defaultMap);
        rover.move("z");
        assertRoverStatus(rover, 0, 0, W);
        assertEquals("Unknown command: z", rover.getErrorMessage());
    }

    @Test
    public void roverReceivesUnknownCommandAfterAGoodMove() {
        Rover rover = new Rover(0, 0, W, defaultMap);
        rover.move("fz");
        assertRoverStatus(rover, -1, 0, W);
        assertEquals("Unknown command: z", rover.getErrorMessage());
    }

    @Test
    public void roverReceivesSeveralUnknownCommandsAfterAGoodMove() {
        Rover rover = new Rover(0, 0, W, defaultMap);
        rover.move("fzx");
        assertRoverStatus(rover, -1, 0, W);
        assertEquals("Unknown command: z", rover.getErrorMessage());
    }

    @Test
    public void roverStopsAtFirstUnknownCommandAfterAGoodMove() {
        Rover rover = new Rover(0, 0, W, defaultMap);
        rover.move("fzf");
        assertRoverStatus(rover, -1, 0, W);
        assertEquals("Unknown command: z", rover.getErrorMessage());
    }

}
