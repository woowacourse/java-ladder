package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

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
                new Line(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT),
                new Line(Direction.DOWN, Direction.RIGHT, Direction.LEFT, Direction.DOWN),
                new Line(Direction.RIGHT, Direction.LEFT, Direction.DOWN, Direction.DOWN),
                new Line(Direction.DOWN, Direction.RIGHT, Direction.LEFT, Direction.DOWN),
                new Line(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT)
        );

        Index index = new Index(indexValue);

        // when
        Index expected = ladder.climb(index);

        // then
        assertThat(expected.getValue()).isEqualTo(actual);
    }
}
