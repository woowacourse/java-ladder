package ladder;

import static ladder.Direction.LEFT;
import static ladder.Direction.RIGHT;
import static ladder.Direction.STRAIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {

    /* returns Ladder lines, described below
        |     |-----|     |
        |-----|     |     |
        |     |     |-----|
     */
    List<Line> createTemplateLines() {
        return List.of(
                new Line(List.of(STRAIGHT, RIGHT, LEFT, STRAIGHT)),
                new Line(List.of(RIGHT, LEFT, STRAIGHT, STRAIGHT)),
                new Line(List.of(STRAIGHT, STRAIGHT, RIGHT, LEFT))
        );
    }

    @Test
    @DisplayName("사다리를 올바르게 생성한다.")
    void validCreationTest() {
        // given
        List<Line> lines = createTemplateLines();
        // when, then
        assertDoesNotThrow(() -> new Ladder(lines));
    }

    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,3", "2,0", "3,2"})
    @DisplayName("사다리의 결과를 올바르게 구한다.")
    void climbDownTest(int startIndex, int expected) {
        // given
        List<Line> lines = createTemplateLines();
        Ladder ladder = new Ladder(lines);
        // when
        Index actual = ladder.climbDown(Index.of(startIndex));
        // then
        assertThat(actual).isEqualTo(Index.of(expected));
    }

    @Test
    @DisplayName("각 줄의 길이가 다르면 예외를 발생한다.")
    void invalidCreationOnLinesSizeDiffer() {
        // given
        List<Line> lines = List.of(
                new Line(List.of(STRAIGHT, RIGHT, LEFT, STRAIGHT)),
                new Line(List.of(RIGHT, LEFT))
        );
        // when, then
        assertThatThrownBy(() -> new Ladder(lines))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
