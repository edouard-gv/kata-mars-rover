package domain.test;

import domain.Direction;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionTest {

    @ParameterizedTest
    @CsvSource({"N,S", "S,N"})
    public void revert(String expected, String input) {
        assertEquals(Direction.valueOf(expected), Direction.valueOf(input).invert());
    }

    @ParameterizedTest
    @CsvSource({"N,E", "E,S", "S,W", "W,N"})
    public void turnLeft(String expected, String input) {
        assertEquals(Direction.valueOf(expected), Direction.valueOf(input).turnLeft());
    }

    @ParameterizedTest
    @CsvSource({"E,N", "N,W", "W,S", "S,E"})
    public void turnRight(String expected, String input) {
        assertEquals(Direction.valueOf(expected), Direction.valueOf(input).turnRight());
    }
}
