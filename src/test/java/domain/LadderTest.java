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
        Ladder ladder = new Ladder(4, givenHeight);

        // when
        int expectedResult = ladder.findLadderHeight();

        // then
        assertThat(expectedResult).isEqualTo(givenHeight);
    }

    @Test
    @DisplayName("Lines의 정보를 반환한다.")
    void returns_lines() {
        // given
        int height = 5;
        Ladder ladder = new Ladder(4, height);

        // when
        Lines lines = ladder.getLines();

        // then
        assertThat(lines.getLines().size()).isEqualTo(height);
    }

}
