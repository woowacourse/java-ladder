package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LadderTest {

    @ParameterizedTest
    @CsvSource({"0,1", "1,0"})
    @DisplayName("사다리의 가로나 세로 값은 1 이상 이어야 한다")
    void testCreate(int width, int height) {
        assertThatThrownBy(() -> new Ladder(width, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("가로 및 높이는 1 이상이어야 한다.");
    }

    @RepeatedTest(10)
    @DisplayName("사다리를 내려간 후 위치는 가로 길이 이내이다")
    void testValidGetResult() {
        final int width = 3, height = 1;
        final Ladder ladder = new Ladder(width, height);

        int resultIndex = ladder.match(0);

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

        assertThatThrownBy(() -> ladder.match(startIndex))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("위치는 0 이상 가로 길이 미만 이어야 한다.");
    }
}
