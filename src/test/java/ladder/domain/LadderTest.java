package ladder.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @DisplayName("가변 인자로 사다리를 생성한다.")
    @Test
    void createLadderWithVarargs() {
        // given
        Line line1 = new Line(4, Direction.FORWARD, Direction.BACKWARD, Direction.FORWARD, Direction.BACKWARD);
        Line line2 = new Line(4, Direction.STAY, Direction.FORWARD, Direction.BACKWARD, Direction.STAY);
        Line line3 = new Line(4, Direction.FORWARD, Direction.BACKWARD, Direction.STAY, Direction.STAY);
        Line line4 = new Line(4, Direction.STAY, Direction.FORWARD, Direction.BACKWARD, Direction.STAY);
        Line line5 = new Line(4, Direction.FORWARD, Direction.BACKWARD, Direction.FORWARD, Direction.BACKWARD);

        // when
        Ladder ladder = new Ladder(5, line1, line2, line3, line4, line5);

        // then
        assertThat(ladder.getRawLadder()).containsExactly(
                List.of(Direction.FORWARD, Direction.BACKWARD, Direction.FORWARD, Direction.BACKWARD),
                List.of(Direction.STAY, Direction.FORWARD, Direction.BACKWARD, Direction.STAY),
                List.of(Direction.FORWARD, Direction.BACKWARD, Direction.STAY, Direction.STAY),
                List.of(Direction.STAY, Direction.FORWARD, Direction.BACKWARD, Direction.STAY),
                List.of(Direction.FORWARD, Direction.BACKWARD, Direction.FORWARD, Direction.BACKWARD)
        );
    }

    @DisplayName("사다리 높이가 최대 사다리 높이와 같지 않으면 예외가 발생한다.")
    @Test
    void validateHeight() {
        // given
        Line line1 = new Line(4, Direction.FORWARD, Direction.BACKWARD, Direction.FORWARD, Direction.BACKWARD);
        Line line2 = new Line(4, Direction.STAY, Direction.FORWARD, Direction.BACKWARD, Direction.STAY);
        Line line3 = new Line(4, Direction.FORWARD, Direction.BACKWARD, Direction.STAY, Direction.STAY);
        Line line4 = new Line(4, Direction.STAY, Direction.FORWARD, Direction.BACKWARD, Direction.STAY);
        Line line5 = new Line(4, Direction.FORWARD, Direction.BACKWARD, Direction.FORWARD, Direction.BACKWARD);

        // when & then
        assertThatThrownBy(() -> new Ladder(4, line1, line2, line3, line4, line5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리를 생성한다.")
    @Test
    void createLadder() {
        // given
        List<Line> lines = List.of(
                new Line(4, Direction.FORWARD, Direction.BACKWARD, Direction.FORWARD, Direction.BACKWARD),
                new Line(4, Direction.STAY, Direction.FORWARD, Direction.BACKWARD, Direction.STAY),
                new Line(4 ,Direction.FORWARD, Direction.BACKWARD, Direction.STAY, Direction.STAY),
                new Line(4, Direction.STAY, Direction.FORWARD, Direction.BACKWARD, Direction.STAY),
                new Line(4, Direction.FORWARD, Direction.BACKWARD, Direction.FORWARD, Direction.BACKWARD)
        );

        // when
        Ladder ladder = new Ladder(5, lines);

        // then
        assertThat(ladder.getRawLadder()).containsExactly(
                List.of(Direction.FORWARD, Direction.BACKWARD, Direction.FORWARD, Direction.BACKWARD),
                List.of(Direction.STAY, Direction.FORWARD, Direction.BACKWARD, Direction.STAY),
                List.of(Direction.FORWARD, Direction.BACKWARD, Direction.STAY, Direction.STAY),
                List.of(Direction.STAY, Direction.FORWARD, Direction.BACKWARD, Direction.STAY),
                List.of(Direction.FORWARD, Direction.BACKWARD, Direction.FORWARD, Direction.BACKWARD)
        );
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
                new Line(4, Direction.FORWARD, Direction.BACKWARD, Direction.FORWARD, Direction.BACKWARD),
                new Line(4, Direction.STAY, Direction.FORWARD, Direction.BACKWARD, Direction.STAY),
                new Line(4, Direction.FORWARD, Direction.BACKWARD, Direction.STAY, Direction.STAY),
                new Line(4, Direction.STAY, Direction.FORWARD, Direction.BACKWARD, Direction.STAY),
                new Line(4, Direction.FORWARD, Direction.BACKWARD, Direction.FORWARD, Direction.BACKWARD)
        );

        Index index = new Index(indexValue);

        // when
        Index expected = ladder.climb(index);

        // then
        assertThat(expected.getValue()).isEqualTo(actual);
    }
}
