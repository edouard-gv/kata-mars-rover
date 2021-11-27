package domain.test;

import domain.Rover;
import org.junit.jupiter.api.Test;

import static domain.Direction.*;


public class EdgeMapTest extends RoverTest {

    @Test
    public void eastLoopsOnWestForward() {
        Rover rover = new Rover(5, 0, E, defaultMap);
        rover.move("f");
        assertRoverStatus(rover, -5, 0, E);
    }

    @Test
    public void westLoopsOnEastForward() {
        Rover rover = new Rover(-5, 0, W, defaultMap);
        rover.move("f");
        assertRoverStatus(rover, 5, 0, W);
    }

    @Test
    public void northLoopsOnSouthForward() {
        Rover rover = new Rover(0, 5, N, defaultMap);
        rover.move("f");
        assertRoverStatus(rover, 0, -5, N);
    }

    @Test
    public void southLoopsOnNorthForward() {
        Rover rover = new Rover(0, -5, S, defaultMap);
        rover.move("f");
        assertRoverStatus(rover, 0, 5, S);
    }
    
    @Test
    public void eastLoopsOnWestBackward() {
        Rover rover = new Rover(5, 0, W, defaultMap);
        rover.move("b");
        assertRoverStatus(rover, -5, 0, W);
    }

    @Test
    public void westLoopsOnEastBackward() {
        Rover rover = new Rover(-5, 0, E, defaultMap);
        rover.move("b");
        assertRoverStatus(rover, 5, 0, E);
    }

    @Test
    public void northLoopsOnSouthBackward() {
        Rover rover = new Rover(0, 5, S, defaultMap);
        rover.move("b");
        assertRoverStatus(rover, 0, -5, S);
    }

    @Test
    public void southLoopsOnNorthBackward() {
        Rover rover = new Rover(0, -5, N, defaultMap);
        rover.move("b");
        assertRoverStatus(rover, 0, 5, N);
    }

}
