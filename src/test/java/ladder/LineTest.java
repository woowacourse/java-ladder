package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {

    @Test
    void 사람수_1보다_보다_작을_때_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Line(0));
    }
}
