import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EdgeMapTest extends RoverTest {

    @Test
    public void eastLoopsOnWest() {
        SpaceMap map = new SpaceMap(5);
        Rover rover = new Rover(5, 0, 'E', map);
        rover.move(List.of('f'));
        assertRoverStatus(rover, -5, 0, 'E');
    }

}
