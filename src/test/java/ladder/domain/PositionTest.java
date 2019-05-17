package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PositionTest {
    @BeforeEach
    void setup() {
        Players.NUM_OF_PLAYERS = 3;
    }

    @Test
    void positionSmallerThanZeroTest() {
        assertThrows(RuntimeException.class, () -> new Position(-1));
    }

    @Test
    void positionBiggerThanOrEqualToNumOfPlayersTest() {
        assertThrows(RuntimeException.class, () -> new Position(3));
    }
}
