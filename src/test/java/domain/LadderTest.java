package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LadderTest {

    @RepeatedTest(10)
    @DisplayName("사다리를 내려간 후 위치는 가로 길이 이내이다")
    void testValidGetResult() {
        final int width = 3, height = 1;
        final Ladder ladder = new Ladder(width, height);

        int resultIndex = ladder.getResult(0);

        assertThat(resultIndex)
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(width);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    @DisplayName("시작 인덱스가 벗어나면 예외가 발생한다.")
    void testInvalidGetResult(int startIndex) {
        final int width = 3, height = 1;
        final Ladder ladder = new Ladder(width, height);

        assertThatThrownBy(() -> ladder.getResult(startIndex))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("위치는 0 이상 가로 길이 미만 이어야 한다.");
    }
}
