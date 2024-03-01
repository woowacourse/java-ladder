package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static domain.Direction.*;
import static org.assertj.core.api.Assertions.*;

class LadderTest {
    @Test
    @DisplayName("사다리 최대 높이가 100을 초과하면 예외가 발생한다")
    void maxHeightTest() {
        final List<Line> lines = new ArrayList<>();
        final Line line = Line.ofDirections(STRAIGHT);
        IntStream.range(0, 101).forEach(number -> lines.add(line));

        assertThatThrownBy(() -> new Ladder(lines)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주어진 사다리의 가로 길이가 일정하지 않을시 예외가 발생한다")
    void LadderShapeTest() {
        final Line line1 = Line.ofDirections(STRAIGHT, STRAIGHT, STRAIGHT);
        final Line line2 = Line.ofDirections(STRAIGHT);
        List<Line> lines = List.of(line1, line2);

        assertThatThrownBy(() -> new Ladder(lines)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,1", "2,2", "3,3"})
    @DisplayName("가로 선이 없는 사다리 게임을 실행 했을 때 같은 위치의 값을 반환한다")
    void nonHorizontalLine(final int startPosition, final int expected) {
        final Ladder ladder = Ladder.of(
                Line.ofDirections(STRAIGHT, STRAIGHT, STRAIGHT, STRAIGHT),
                Line.ofDirections(STRAIGHT, STRAIGHT, STRAIGHT, STRAIGHT),
                Line.ofDirections(STRAIGHT, STRAIGHT, STRAIGHT, STRAIGHT)
        );

        final int endPosition = ladder.play(startPosition);

        assertThat(endPosition).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,3", "1,0", "2,1", "3,2"})
    @DisplayName("사다리 게임을 실행 했을 때 올바른 결과를 반환한다")
    void gameResultTest(final int startPosition, final int expected) {
        final Ladder ladder = Ladder.of(
                Line.ofDirections(RIGHT, LEFT, STRAIGHT, STRAIGHT),
                Line.ofDirections(STRAIGHT, RIGHT, LEFT, STRAIGHT),
                Line.ofDirections(STRAIGHT, STRAIGHT, RIGHT, LEFT)
        );

        final int endPosition = ladder.play(startPosition);

        assertThat(endPosition).isEqualTo(expected);
    }
//
//    @Test
//    @DisplayName("빈 리스트가 주어졌을 때 사다리를 생성하면 예외를 발생시킨다")
//    void emptyList() {
//        final List<Line> lines = new ArrayList<>();
//
//        assertThatThrownBy(() -> LadderFactory.createLadder(lines))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
}
