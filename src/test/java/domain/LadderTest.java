package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}
