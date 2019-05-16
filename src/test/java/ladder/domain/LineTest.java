package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {
    @Test
    void 사이즈_검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Line(0);
        });
    }

    @Test
    void 서브라인_유효성_검사() {
        List<Boolean> expectedList = Arrays.asList(true, true, false);

        assertThrows(IllegalArgumentException.class, () -> {
            Line line = new Line(5, () -> expectedList);
        });
    }

    @Test
    void 서브라인_검사() {
        List<Boolean> expectedList = Arrays.asList(true, false, false, true, false);

        Line line = new Line(expectedList.size(), () -> expectedList);

        List<Boolean> actual = line.getSubLines();

        IntStream.range(0, expectedList.size())
                .forEach(index -> assertThat(actual.get(index))
                        .isEqualTo(expectedList.get(index)));
    }
}
