package ladder.model.ladder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointsTest {
    @Test
    void 겹치는_가로라인_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> new Points(Arrays.asList(new Point(false), new Point(true), new Point(true))));
    }

    @Test
    void 겹치지_않는_가로라인_확인() {
        assertDoesNotThrow(() -> new Points(Arrays.asList(new Point(false), new Point(true), new Point(false))));
    }
}
