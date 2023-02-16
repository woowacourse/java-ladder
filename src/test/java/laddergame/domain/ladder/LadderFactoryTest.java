package laddergame.domain.ladder;

import laddergame.domain.rung.RungNumberGenerator;
import laddergame.util.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static laddergame.domain.message.ErrorMessage.INVALID_HEIGHT_RANGE;
import static laddergame.domain.message.ErrorMessage.INVALID_HEIGHT_TYPE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LadderFactoryTest {

    private LadderFactory ladderFactory;
    private int participantCount;

    @BeforeEach
    void init() {
        NumberGenerator rungNumberGenerator = new RungNumberGenerator();
        ladderFactory = LadderFactory.create(rungNumberGenerator);
        participantCount = 4;
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "10000"})
    @DisplayName("1 이상의 정수 범위의 사다리 높이가 들어오면, 예외가 발생하지 않는다.")
    void ladder_create_test(String height) {
        // when & then
        assertDoesNotThrow(() -> ladderFactory.createLadder(height, participantCount));
        assertThat(ladderFactory.createLadder(height, participantCount))
                .isInstanceOf(Ladder.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hi", "23fgie", "@#$%$"})
    @DisplayName("정수 값이 아닌 사다리 높이가 들어오면, 예외가 발생한다.")
    void ladder_height_type_error_test(String height) {
        // when & then
        assertThatThrownBy(() -> ladderFactory.createLadder(height, participantCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_HEIGHT_TYPE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "10001"})
    @DisplayName("1~10000 범위를 벗어난 사다리 높이가 입력되면, 예외가 발생한다.")
    void ladder_height_range_error_test(String height) {
        // when & then
        assertThatThrownBy(() -> ladderFactory.createLadder(height, participantCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_HEIGHT_RANGE.getMessage());
    }
}
