package domain.ladder;

import common.exception.message.ExceptionMessage;
import domain.ladder.LadderHeight;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderHeightTest {

    @Nested
    @DisplayName("사다리 높이 범위 테스트")
    class LadderHeightRangeTest {
        @ParameterizedTest
        @ValueSource(ints = {2, 10})
        void createLadderHeightSuccessWithRange(int value) {
            LadderHeight ladderHeight = new LadderHeight(value);
            Assertions.assertThat(ladderHeight.getValue()).isEqualTo(value);
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 11})
        @DisplayName("높이가 2 미만, 10 초과라면 예외가 발생한다")
        void createLadderHeightFailByRange(int value) {
            Assertions.assertThatThrownBy(() -> new LadderHeight(value))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.LADDER_HEIGHT_RANGE);
        }
    }
}
