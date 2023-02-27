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
        // given
        int lineSize = 31;
        List<Line> lines = new ArrayList<>();
        for (int lineIndex = 0; lineIndex < lineSize; lineIndex++) {
            lines.add(new Line(List.of(Point.EXIST, Point.NOT_EXIST, Point.NOT_EXIST)));
        }

        // when, then
        Assertions.assertThatThrownBy(() -> new Ladder(lines))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리의 높이는 1이상 30이하여야 합니다.");
    }

    @DisplayName("사다리의 최대 높이는 1보다 작을 수 없다.")
    @Test
    void lineSizeNotLessThan1() {
        // given
        List<Line> lines = Collections.emptyList();

        // when, then
        Assertions.assertThatThrownBy(() -> new Ladder(lines))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리의 높이는 1이상 30이하여야 합니다.");
    }

    @DisplayName("사다리의 높이는 1이상 30이하이다.")
    @ValueSource(ints = {1, 10, 30})
    @ParameterizedTest
    void lineSizeTest(int lineSize) {
        // given
        List<Line> lines = new ArrayList<>();
        for (int lineIndex = 0; lineIndex < lineSize; lineIndex++) {
            lines.add(new Line(List.of(Point.EXIST, Point.NOT_EXIST, Point.NOT_EXIST)));
        }
        Ladder ladder = new Ladder(lines);

        // when
        int ladderSize = ladder.getLines().size();

        //
        assertThat(ladderSize).isEqualTo(lineSize);
    }

}
