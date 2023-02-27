package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 100})
    @DisplayName("높이가 1이상 100이하이면 사다리가 생성된다.")
    void createLine_Success(int height) {
        assertThatNoException().isThrownBy(() -> new LadderMaker(5, new Height(height)));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 101})
    @DisplayName("높이가 1미만 100초과이면 예외가 발생한다.")
    void createLine_Fail(int height) {
        assertThatThrownBy(() -> new LadderMaker(5, new Height(height)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리 높이는 1이상 100이하의 자연수만 가능합니다.");
    }

}