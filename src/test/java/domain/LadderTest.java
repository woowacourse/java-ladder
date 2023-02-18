package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

    @DisplayName("사다리의 높이만큼 라인을 생성한다")
    @ParameterizedTest(name = "{index} : 사다리 높이 {0}만큼 라인을 생성한다 ")
    @ValueSource(ints = {3, 4, 5, 6})
    void ladder_height_test(int height) {
        Ladder ladder = new Ladder(4, height, new RandomGenerateStrategy());
        assertThat(ladder.getHeight()).isEqualTo(height);
    }

    @DisplayName("사다리의 높이가 1 이상 10 이하가 아니면 예외가 발생한다.")
    @ParameterizedTest(name = "{index} : 현재 사다리 높이 = {0}")
    @ValueSource(ints = {-1, 0, 11})
    void ladder_invalid_test(int height) {
        assertThatThrownBy(() -> new Ladder(4, height, new RandomGenerateStrategy()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 1 이상 10 이하여야 합니다");
    }

    @DisplayName("사다리의 높이가 1 이상 10 이하이면 사다리를 생성한다.")
    @ParameterizedTest(name = "{index} : 현재 사다리 높이 = {0}")
    @ValueSource(ints = {1, 5, 10})
    void ladder_valid_test(int height) {
        assertDoesNotThrow(() -> new Ladder(4, height, new RandomGenerateStrategy()));
    }

    @DisplayName("사람 {수 -1} 길이의 사다리의 폭을 생성한다")
    @ParameterizedTest(name = "{index} : 사다리의 폭의 길이는 {0}-1 이다 ")
    @ValueSource(ints = {3, 4, 5, 6})
    void ladder_width_test(int personCount) {
        Ladder ladder = new Ladder(personCount, 3, new RandomGenerateStrategy());
        assertThat(ladder.getWidth()).isEqualTo(personCount - 1);
    }
}
