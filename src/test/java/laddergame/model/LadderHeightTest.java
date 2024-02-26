package laddergame.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderHeightTest {

    @DisplayName("사다리 높이가 최소 높이보다 작으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-5, -1, 0})
    void validateLadderHeight(int given) {
        assertThatThrownBy(() -> new LadderHeight(given))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
