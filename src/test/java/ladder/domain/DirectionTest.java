package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DirectionTest {
    @Test
    void consecutiveTrueTest() {
        assertThrows(RuntimeException.class, () -> {
            new Direction(true, true);
        });
    }
}
