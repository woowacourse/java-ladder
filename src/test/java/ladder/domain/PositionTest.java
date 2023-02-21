package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PositionTest {

    @ParameterizedTest(name = "위치값이 0보다 작거나 20보다 큰 경우 예외를 던진다 입력값: {0}")
    @ValueSource(ints = {-1, 0, 21})
    void 위치값이_1보다_작거나_20보다_큰_경우_예외를_던진다(final int value) {
        assertThatThrownBy(() -> Position.valueOf(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("위치값은 1이상, 20이하여야 합니다.");
    }

    @ParameterizedTest(name = "올바른 위치값을 받으면 정상적으로 생성된다. 입력값: {0}")
    @ValueSource(ints = {1, 20})
    void 올바른_위치값을_받으면_정상적으로_생성된다(final int value) {
        final Position position = Position.valueOf(value);

        assertThat(position.getValue()).isEqualTo(value);
    }
}
