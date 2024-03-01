package ladder.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @DisplayName("사다리 높이가 최대 사다리 높이와 같지 않으면 예외가 발생한다.")
    @Test
    void validateHeight() {
        // given
        List<Line> lines = List.of(
                new Line(4, Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT),
                new Line(4, Direction.DOWN, Direction.RIGHT, Direction.LEFT, Direction.DOWN),
                new Line(4 ,Direction.RIGHT, Direction.LEFT, Direction.DOWN, Direction.DOWN),
                new Line(4, Direction.DOWN, Direction.RIGHT, Direction.LEFT, Direction.DOWN),
                new Line(4, Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT)
        );

        // when & then
        assertThatThrownBy(() -> new Ladder(4, lines))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("특정 참여자의 사다리를 탄다.")
    @ParameterizedTest
    @CsvSource(value = {"0, 0", "1, 3", "2, 2,", "3, 1"})
    void climb(int indexValue, int actual) {
        // given
        /*
        |-----|     |-----|
        |     |-----|     |
        |-----|     |     |
        |     |-----|     |
        |-----|     |-----|
         */
        Ladder ladder = new Ladder(
                5,
                new Line(4, Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT),
                new Line(4, Direction.DOWN, Direction.RIGHT, Direction.LEFT, Direction.DOWN),
                new Line(4, Direction.RIGHT, Direction.LEFT, Direction.DOWN, Direction.DOWN),
                new Line(4, Direction.DOWN, Direction.RIGHT, Direction.LEFT, Direction.DOWN),
                new Line(4, Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT)
        );

        Index index = new Index(indexValue);

        // when
        Index expected = ladder.climb(index);

        // then
        assertThat(expected.getValue()).isEqualTo(actual);
    }
}
