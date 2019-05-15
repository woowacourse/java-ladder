package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {
    @Test
    void 사이즈_검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Line(Arrays.asList());
        });
    }

    @Test
    void 서브라인_유효성_검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Line(Arrays.asList(true, true));
        });
    }
}