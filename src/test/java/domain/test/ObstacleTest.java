package domain.test;

import domain.Position;
import domain.Rover;
import domain.SpaceMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import static domain.Direction.*;

public class ObstacleTest extends RoverTest {

    protected static SpaceMap mapWithAnObstacle;

    @BeforeAll
    public static void initializeMap() {
        List<Position> obstacles = List.of(new Position(0, 1));
        mapWithAnObstacle = new SpaceMap(5, obstacles);
    }

    @Test
    public void stopWhenObstacleAtNorthFacingNorthGoingForward() {
        Rover rover = new Rover(0, 0, N, mapWithAnObstacle);
        rover.move("f");
        assertRoverStatus(rover, 0, 0, N);
        assertEquals("Obstacle found at 0,1", rover.getErrorMessage());
    }

    @Test
    public void reallyStopsWhenObstacleAtNorthFacingNorthGoingForward() {
        Rover rover = new Rover(0, 0, N, mapWithAnObstacle);
        rover.move("ffrf");
        assertRoverStatus(rover, 0, 0, N);
        assertEquals("Obstacle found at 0,1", rover.getErrorMessage());
    }

    @Test
    public void stopWhenObstacleAtSouthFacingSouthGoingForward() {
        Rover rover = new Rover(0, 2, S, mapWithAnObstacle);
        rover.move("f");
        assertRoverStatus(rover, 0, 2, S);
        assertEquals("Obstacle found at 0,1", rover.getErrorMessage());
    }

    @Test
    public void stopWhenObstacleAtEastFacingEastGoingForward() {
        Rover rover = new Rover(-1, 1, E, mapWithAnObstacle);
        rover.move("f");
        assertRoverStatus(rover, -1, 1, E);
        assertEquals("Obstacle found at 0,1", rover.getErrorMessage());
    }

    @Test
    public void stopWhenObstacleAtWestFacingWestGoingForward() {
        Rover rover = new Rover(1, 1, W, mapWithAnObstacle);
        rover.move("f");
        assertRoverStatus(rover, 1, 1, W);
        assertEquals("Obstacle found at 0,1", rover.getErrorMessage());
    }

    @Test
    public void stopWhenObstacleAtNorthFacingSouthGoingBackward() {
        Rover rover = new Rover(0, 0, S, mapWithAnObstacle);
        rover.move("b");
        assertRoverStatus(rover, 0, 0, S);
        assertEquals("Obstacle found at 0,1", rover.getErrorMessage());
    }

    @Test
    public void stopWhenObstacleAtSouthFacingNorthGoingBackward() {
        Rover rover = new Rover(0, 2, N, mapWithAnObstacle);
        rover.move("b");
        assertRoverStatus(rover, 0, 2, N);
        assertEquals("Obstacle found at 0,1", rover.getErrorMessage());
    }

    @Test
    public void stopWhenObstacleAtEastFacingWestGoingBackward() {
        Rover rover = new Rover(-1, 1, W, mapWithAnObstacle);
        rover.move("b");
        assertRoverStatus(rover, -1, 1, W);
        assertEquals("Obstacle found at 0,1", rover.getErrorMessage());
    }

    @Test
    public void stopWhenObstacleAtWestFacingEastGoingBackward() {
        Rover rover = new Rover(1, 1, E, mapWithAnObstacle);
        rover.move("b");
        assertRoverStatus(rover, 1, 1, E);
        assertEquals("Obstacle found at 0,1", rover.getErrorMessage());
    }

    @Test
    public void stopWhenObstacleAtTwoStepsNorthFacingNorthGoingForward() {
        Rover rover = new Rover(0, -1, N, mapWithAnObstacle);
        rover.move("ff");
        assertRoverStatus(rover, 0, 0, N);
        assertEquals("Obstacle found at 0,1", rover.getErrorMessage());
    }


}
