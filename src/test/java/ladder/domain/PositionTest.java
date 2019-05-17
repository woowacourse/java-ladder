package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PositionTest {
    @BeforeEach
    void setup() {
        Position.MAX = 3;
    }

    @Test
    void positionSmallerThanZeroTest() {
        assertThrows(RuntimeException.class, () -> new Position(-1));
    }
}
