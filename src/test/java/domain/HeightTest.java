package domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {

    @DisplayName("높이가 2이상 10이하면 예외가 발생하지않는다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 10})
    public void createSuccess(int input) {
        assertThatCode(() ->
                new Height(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("높이가 2미만 10초과면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 11})
    public void createFail(int input) {
        assertThatCode(() ->
                new Height(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
