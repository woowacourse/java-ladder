package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("사다리의 최대 높이는 30을 넘을 수 없다.")
    @Test
    void lineSizeNotMoreThan30() {
        int lineSize = 31;
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < lineSize; i++) {
            lines.add(new Line(10));
        }
        Assertions.assertThatThrownBy(() -> new Ladder(lines))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리의 높이는 1이상 30이하여야 합니다.");
    }

    @DisplayName("사다리의 최대 높이는 1보다 작을 수 없다.")
    @Test
    void lineSizeNotLessThan1() {
        List<Line> lines = Collections.emptyList();
        Assertions.assertThatThrownBy(() -> new Ladder(lines))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리의 높이는 1이상 30이하여야 합니다.");
    }

    @DisplayName("사다리의 높이는 1이상 30이하이다.")
    @ValueSource(ints = {1, 10, 30})
    @ParameterizedTest
    void lineSizeTest(int lineSize) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < lineSize; i++) {
            lines.add(new Line(10));
        }
        Ladder ladder = new Ladder(lines);
        assertThat(ladder.getLines().size()).isEqualTo(lineSize);
    }

}
