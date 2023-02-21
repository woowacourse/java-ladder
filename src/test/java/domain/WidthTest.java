package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("사다리의 너비는, ")
public class WidthTest {
    @ParameterizedTest
    @ValueSource(ints = {0,10})
    @DisplayName("1~9를 넘어가면 예외가 발생한다.")
    void widthRangeFailTest(int width) {
        Assertions.assertThatThrownBy(() -> new Width(width))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,8,9})
    @DisplayName("1~9를 사이면 정상적으로 수행된다.")
    void widthRangeSuccessTest(int width) {
        Assertions.assertThatCode(() -> new Width(width))
                .doesNotThrowAnyException();
    }
}
