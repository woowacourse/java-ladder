package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static laddergame.TestDummy.TEST_LINE_CREATOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("라인 Creator")
class LineCreatorTest {

    @DisplayName("BooleanGenerator가 null이면 예외가 발생한다.")
    @Test
    void throwExceptionWhenBooleanGeneratorIsNull() {
        final BooleanGenerator generator = null;
        assertThatThrownBy(() -> new LineCreator(generator));
    }

    @DisplayName("가로 길이가 0 이하이면 예외가 발생한다.")
    @Test
    void throwExceptionWhenWidthIsNotPositive() {
        assertThatThrownBy(() -> TEST_LINE_CREATOR.createLines(0, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("세로 길이가 0 이하이면 예외가 발생한다.")
    @Test
    void throwExceptionWhenHeightIsNotPositive() {
        assertThatThrownBy(() -> TEST_LINE_CREATOR.createLines(1, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("라인 사이즈는 세로 길이와 같다.")
    @Test
    void returnsLinesSizeIsHeight() {
        final List<Line> lines = TEST_LINE_CREATOR.createLines(3, 2);
        assertThat(lines).hasSize(2);
    }
}