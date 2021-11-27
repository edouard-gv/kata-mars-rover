import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class ObstacleTest extends RoverTest {

    protected static SpaceMap mapWithAnObstacle;

    @BeforeAll
    public static void initializeMap() {
        List<Position> obstacles = List.of(new Position(0, 1));
        mapWithAnObstacle = new SpaceMap(5, obstacles);
    }

    @Test
    public void stopWhenObstacleAtNorthFacingNorthGoingForward() {
        Rover rover = new Rover(0, 0, 'N', mapWithAnObstacle);
        rover.move(List.of('f'));
        assertRoverStatus(rover, 0, 0, 'N');
        assertEquals("Obstacle found at 0,1", rover.getErrorMessage());
    }

    @Test
    public void stopWhenObstacleAtTwoStepsNorthFacingNorthGoingForward() {
        Rover rover = new Rover(0, -1, 'N', mapWithAnObstacle);
        rover.move(List.of('f', 'f'));
        assertRoverStatus(rover, 0, 0, 'N');
        assertEquals("Obstacle found at 0,1", rover.getErrorMessage());
    }
}
