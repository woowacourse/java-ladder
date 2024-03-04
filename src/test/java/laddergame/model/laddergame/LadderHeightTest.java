package laddergame.model.laddergame;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import laddergame.exception.BaseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderHeightTest {
    @DisplayName("사다리 높이가 최소 높이보다 작으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-5, -1, 0})
    void validateLadderHeight(int given) {
        //when //then
        assertThatThrownBy(() -> new LadderHeight(given))
                .isInstanceOf(BaseException.class);
    }
}
