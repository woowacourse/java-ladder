package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {
    @Test
    void 사이즈_검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Line(new ArrayList<>());
        });
    }
}
