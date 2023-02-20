package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ResultTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    @DisplayName("결과 값의 길이가 1보다 작거나 5보다 크면 예외를 던진다.")
    void throws_exception_when_length_of_result_is_invalid_range(String input) {
        // when & then
        assertThatThrownBy(() -> new Result(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("결과 값의 길이는 1이상 5이하만 가능합니다.");
    }
}
