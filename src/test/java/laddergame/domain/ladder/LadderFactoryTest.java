package laddergame.domain.ladder;

import laddergame.domain.rung.RungBooleanGenerator;
import laddergame.util.BooleanGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static laddergame.domain.message.ErrorMessage.INVALID_HEIGHT_RANGE;
import static laddergame.domain.message.ErrorMessage.INVALID_HEIGHT_TYPE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LadderFactoryTest {

    private LadderFactory ladderFactory;
    private int participantCount;

    @BeforeEach
    void init() {
        BooleanGenerator rungBooleanGenerator = new RungBooleanGenerator();
        ladderFactory = LadderFactory.create(rungBooleanGenerator);
        participantCount = 4;
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "5000", "10000"})
    @DisplayName("사다리 높이가 1 이상 10000 이하이면, 예외가 발생하지 않는다.")
    void does_not_throw_exception_if_height_is_between_1_and_10000(String height) {
        assertDoesNotThrow(() -> ladderFactory.makeLadder(height, participantCount));
    }

    @ParameterizedTest
    @ValueSource(strings = {"hi", "23fgie", "@#$%$"})
    @DisplayName("사다리 높이가 정수가 아니면, 예외가 발생한다.")
    void throws_exception_if_height_is_not_integer_type(String height) {
        assertThatThrownBy(() -> ladderFactory.makeLadder(height, participantCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_HEIGHT_TYPE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "10001"})
    @DisplayName("사다리 높이가 1 미만 혹은 10000 초과이면, 예외가 발생한다.")
    void throws_exception_if_height_is_less_than_1_or_greater_than_10000(String height) {
        assertThatThrownBy(() -> ladderFactory.makeLadder(height, participantCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_HEIGHT_RANGE.getMessage());
    }
}
