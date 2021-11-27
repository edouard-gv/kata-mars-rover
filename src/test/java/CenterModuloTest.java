import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CenterModuloTest {

    @ParameterizedTest
    @MethodSource
    public void assertGoodModulo(int expectedPosition, int oldPosition) {
        SpaceMap map = new SpaceMap(5);
        assertEquals(expectedPosition, map.putBack(oldPosition));

    }

    private static Stream<Arguments> assertGoodModulo() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(5, 5),
                Arguments.of(-5, 6),
                Arguments.of(-5, -5),
                Arguments.of(5, -6)
        );
    }
}
