import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {
    protected void assertRoverStatus(Rover rover, int expected_x, int expected_y, char expected_direction) {
        assertEquals(expected_x, rover.x());
        assertEquals(expected_y, rover.y());
        assertEquals(expected_direction, rover.direction());
    }

}
