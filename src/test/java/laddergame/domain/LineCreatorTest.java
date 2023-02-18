package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static laddergame.fixture.LineCreatorFixture.TEST_LINE_CREATOR;
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
    @ParameterizedTest(name = "heightValue = {0}")
    @ValueSource(ints = {-4, -3, -2, -1, 0})
    void throwExceptionWhenWidthIsNotPositive(final int heightValue) {
        assertThatThrownBy(() -> TEST_LINE_CREATOR.createLines(0, heightValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("세로 길이가 0 이하이면 예외가 발생한다.")
    @ParameterizedTest(name = "widthValue = {0}")
    @ValueSource(ints = {-4, -3, -2, -1, 0})
    void throwExceptionWhenHeightIsNotPositive(final int widthValue) {
        assertThatThrownBy(() -> TEST_LINE_CREATOR.createLines(widthValue, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("라인 사이즈는 세로 길이와 같다.")
    @ParameterizedTest(name = "heightValue = {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void returnsLinesSizeIsHeight(final int heightValue) {
        final List<Line> lines = TEST_LINE_CREATOR.createLines(3, heightValue);
        assertThat(lines).hasSize(heightValue);
    }
}