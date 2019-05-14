package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {

    @Test
    void 겹치는라인테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Line(Arrays.asList(true, true)));
    }

    @Test
    void 겹치지않는라인테스트() {
        assertDoesNotThrow(() -> new Line(Arrays.asList(true, false)));
        assertDoesNotThrow(() -> new Line(Arrays.asList(false, true)));
        assertDoesNotThrow(() -> new Line(Arrays.asList(false, false)));
    }


}
