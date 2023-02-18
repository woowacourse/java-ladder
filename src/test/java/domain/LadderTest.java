package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.ExistFootholdGenerator;
import util.NonExistFootholdGenerator;

class LadderTest {

    @Test
    @DisplayName("사다리의 높이를 찾는다.")
    void returns_height_of_ladder() {
        // given
        int givenHeight = 5;
        int givenNumberOfPlayer = 3;
        Lines lines = new Lines(givenNumberOfPlayer, givenHeight);
        Height height = new Height(givenHeight);
        Ladder ladder = new Ladder(lines, height);

        // when
        int expectedHeight = ladder.findLadderHeight();

        // then
        assertThat(expectedHeight).isEqualTo(givenHeight);
    }

    @Test
    @DisplayName("Lines의 정보를 반환한다.")
    void returns_lines() {
        // given
        int givenHeight = 5;
        int givenNumberOfPlayer = 3;
        Lines lines = new Lines(givenNumberOfPlayer, givenHeight);
        Height height = new Height(givenHeight);
        Ladder ladder = new Ladder(lines, height);

        // when
        Lines expectedLines = ladder.getLines();

        // then
        assertThat(expectedLines.getLines().size()).isEqualTo(givenHeight);
    }

    @Test
    @DisplayName("해당하는 높이의 사다리 라인을 반환한다.")
    void returns_line_using_index_of_height() {
        // given
        int givenHeight = 0;
        Line line1 = new Line(4, new NonExistFootholdGenerator());
        Line line2 = new Line(4, new ExistFootholdGenerator());
        Lines lines = new Lines(List.of(line1, line2));
        Ladder ladder = new Ladder(lines, new Height(2));

        // when
        List<Boolean> lineUsingIndexOfHeight = ladder.findLineUsingIndexOfHeight(givenHeight);

        // then
        assertThat(lineUsingIndexOfHeight).containsExactly(false, false, false);
    }
}
