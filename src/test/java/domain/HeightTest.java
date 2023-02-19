package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {

    @ParameterizedTest(name = "사다리의 높이가 1 이상 10 이하라면 예외를 던지지 않는다. 입력값:{0}")
    @ValueSource(ints = {1, 5, 10})
    void should_notThrowException_when_heightIsValid(int height) {
        assertThatCode(() -> new Height(height))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "사다리의 높이가 1 미만 10 초과라면 예외를 던진다. 입력값:{0}")
    @ValueSource(ints = {-1, 0, 11})
    void should_throwException_when_heightIsInvalid(int height) {
        assertThatThrownBy(() -> new Height(height))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
