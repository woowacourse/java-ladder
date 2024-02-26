package ladder.domain.resource.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import ladder.domain.resource.direction.DirectionGeneratorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderGeneratorTest {

    LadderGenerator ladderGenerator = new LadderGenerator(new DirectionGeneratorImpl());

    @DisplayName("원하는 가로와 세로 길이를 가진 사다리를 생성한다.")
    @Test
    void generateTest() {
        //given
        int height = 2;
        int width = 2;

        //when
        Ladder ladder = ladderGenerator.generate(height, width);

        //then
        assertThat(ladder.getHeight()).isEqualTo(height);
        assertThat(ladder.getWidth()).isEqualTo(width);
    }

    @DisplayName("사다리의 높이의 범위가 1~50이 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 51})
    void generateTestByHeightOutOfRange(int height) {
        //given
        int width = 2;

        //when, then
        assertThatThrownBy(() -> ladderGenerator.generate(height, width))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사다리의 높이는 1~50만 가능합니다.");
    }

    @DisplayName("사다리의 너비의 범위가 2~10이 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 11})
    void generateTestByWidthOutOfRange(int width) {
        //given
        int height = 1;

        //when, then
        assertThatThrownBy(() -> ladderGenerator.generate(height, width))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사다리의 너비는 2~10만 가능합니다.");
    }
}
