package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {
    @DisplayName("사다리 높이는 1 이상 100 이하이다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 99, 100})
    void validHeightTest(int value) {
        Assertions.assertDoesNotThrow(
                () -> new Height(value)
        );
    }

    @DisplayName("사다리 높이가 1 미만 100 초과인 경우 예외 처리한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 101, 102})
    void invalidHeightTest(int value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Height(value))
                .withMessageContaining("[ERROR] 1 이상 100 이하의 자연수만 입력해 주세요.");
    }
}
