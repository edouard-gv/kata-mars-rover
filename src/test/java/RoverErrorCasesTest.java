import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverErrorCasesTest extends RoverTest {


    @Test
    public void roverReceiveCorrectCommand() {
        Rover rover = new Rover(0, 0, 'N');
        rover.move(List.of('f'));
        assertEquals(null, rover.getErrorMessage());
    }

    @Test
    public void roverReceivesUnknownCommand() {
        Rover rover = new Rover(0, 0, 'W');
        rover.move(List.of('z'));
        assertRoverStatus(rover, 0, 0, 'W');
        assertEquals("Unknown command: z", rover.getErrorMessage());
    }

    @Test
    public void roverReceivesUnknownCommandAfterAGoodMove() {
        Rover rover = new Rover(0, 0, 'W');
        rover.move(List.of('f', 'z'));
        assertRoverStatus(rover, -1, 0, 'W');
        assertEquals("Unknown command: z", rover.getErrorMessage());
    }
}
