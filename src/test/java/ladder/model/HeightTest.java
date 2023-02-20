package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

class HeightTest {
    @ParameterizedTest
    @DisplayName("사다리 높이가 허용 범위 밖이면 예외처리 테스트")
    @ValueSource(ints = {1, 101})
    void invalidHeightTest(int height) {
        Assertions.assertThatThrownBy(() -> new Height(height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("사다리 높이가 허용 범위 안이면 예외처리 테스트")
    @ValueSource(ints = {2, 100})
    void validHeightTest(int height) {
        assertThatCode(() -> new Height(height)).doesNotThrowAnyException();
    }

}
