import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class RoverTest {

    @Test
    public void roverReceiveNoCommands() {
        Rover rover = new Rover(0, 0, 'N');
        List<String> commands = List.of(); //is immutable by construct
        rover.move(commands);
        assertEquals(0, rover.x());
        assertEquals(0, rover.y());
        assertEquals('N', rover.direction());
    }
}
