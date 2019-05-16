package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void 첫번째값이동테스트() {
        assertThat(new Line(Arrays.asList(true, false)).getDirection(0)).isEqualTo(Line.RIGHT);
    }

    @Test
    void 가운데값이동테스트() {
        assertThat(new Line(Arrays.asList(true, false)).getDirection(1)).isEqualTo(Line.LEFT);
    }

    @Test
    void 마지막값이동테스트() {
        assertThat(new Line(Arrays.asList(true, false)).getDirection(2)).isEqualTo(Line.STRAIGHT);
    }


}
