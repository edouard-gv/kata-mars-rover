package domain.test;

import domain.Direction;
import domain.Rover;
import domain.SpaceMap;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {
    protected static SpaceMap defaultMap;

    protected void assertRoverStatus(Rover rover, int expected_x, int expected_y, Direction expected_direction) {
        assertEquals(expected_x, rover.position().x());
        assertEquals(expected_y, rover.position().y());
        assertEquals(expected_direction, rover.direction());
    }

    @BeforeAll
    public static void initializeMap() {
        defaultMap = new SpaceMap(5);
    }
}
