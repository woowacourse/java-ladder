package ladder.domain;

import static ladder.domain.Position.INVALID_VALUE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PositionTest {

    @ParameterizedTest(name = "위치값이 0보다 작거나 20이상인 경우 예외를 던진다 입력값: {0}")
    @ValueSource(ints = {-1, 20})
    void 위치값이_0보다_작거나_20이상인_경우_예외를_던진다(final int value) {
        assertThatThrownBy(() -> Position.valueOf(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_VALUE_MESSAGE);
    }

    @ParameterizedTest(name = "올바른 위치값을 받으면 정상적으로 생성된다. 입력값: {0}")
    @ValueSource(ints = {0, 19})
    void 올바른_위치값을_받으면_정상적으로_생성된다(final int value) {
        final Position position = Position.valueOf(value);

        assertThat(position.getValue()).isEqualTo(value);
    }

    @Test
    void 입력한_값까지의_Position을_반환한다() {
        final List<Position> positions = Position.range(3);

        assertThat(positions).containsExactly(Position.valueOf(0), Position.valueOf(1), Position.valueOf(2));
    }

    @Test
    void 허용범위_밖_위치값을_입력하는_경우_예외를_던진다() {
        assertThatThrownBy(() -> Position.range(21))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_VALUE_MESSAGE);
    }

    @ParameterizedTest
    @CsvSource({"1,true", "0,false"})
    void 이전값이_올바른_값이라면_참_올바르지_않다면_거짓을_반환한다(final int value, final boolean result) {
        final Position position = Position.valueOf(value);

        assertThat(position.hasPrevious()).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({"18,true", "19,false"})
    void 다음값이_올바른_값이라면_참_올바르지_않다면_거짓을_반환한다(final int value, final boolean result) {
        final Position position = Position.valueOf(value);

        assertThat(position.hasNext()).isEqualTo(result);
    }

    @Test
    void 이전_값이_올바른_값이_아닌_경우_예외를_던진다() {
        final Position position = Position.valueOf(0);

        assertThatThrownBy(position::getPrevious)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_VALUE_MESSAGE);
    }

    @Test
    void 이전_값을_반환한다() {
        final Position position = Position.valueOf(1);

        assertThat(position.getPrevious()).isEqualTo(Position.valueOf(0));
    }

    @Test
    void 다음_값이_올바른_값이_아닌_경우_예외를_던진다() {
        final Position position = Position.valueOf(19);

        assertThatThrownBy(position::getNext)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_VALUE_MESSAGE);
    }

    @Test
    void 다음_값을_반환한다() {
        final Position position = Position.valueOf(18);

        assertThat(position.getNext()).isEqualTo(Position.valueOf(19));
    }
}
