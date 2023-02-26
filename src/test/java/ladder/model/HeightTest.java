package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

class HeightTest {
    @ParameterizedTest
    @DisplayName("사다리 높이가 2 미만 또는 100 초과면 예외처리 테스트")
    @ValueSource(ints = {1, 101})
    void invalidHeightTest(int input) {
        Assertions.assertThatThrownBy(() -> new Height(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("사다리 높이가 2 이상 100 이하면 통과하는 테스트")
    @ValueSource(ints = {2, 100})
    void validHeightTest(int input) {
        assertThatCode(() -> new Height(input)).doesNotThrowAnyException();
    }

}
