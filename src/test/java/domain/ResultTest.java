package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ResultTest {

    @ParameterizedTest
    @ValueSource(strings = {""})
    @DisplayName("결과 값의 길이가 1보다 작으면 예외를 던진다.")
    void throws_exception_when_length_of_result_is_invalid_range(String input) {
        // when & then
        assertThatThrownBy(() -> new Result(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("결과 값의 길이는 1이상만 가능합니다.");
    }


}
