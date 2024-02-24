package ladder.domain.ladder;

import ladder.exception.ladder.InvalidHeightRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class HeightTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -100})
    @DisplayName("최대 사다리 높이가 1이상이 아니면 예외가 발생한다.")
    void checkInvalidLadderHeightTest(final int height) {
        // when & then
        assertThatThrownBy(() -> new Height(height))
                .isInstanceOf(InvalidHeightRangeException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 30})
    @DisplayName("최대 사다리 높이가 양의 정수이면 예외가 발생하지 않는다.")
    void checkLadderHeightTest(final int height) {
        // when & then
        assertThatCode(() -> new Height(height))
                .doesNotThrowAnyException();
    }
}
