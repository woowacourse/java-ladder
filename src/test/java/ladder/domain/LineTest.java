package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {
    @Test
    void 사이즈_검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Line(0);
        });
    }
}
