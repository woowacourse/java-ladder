package laddergame.domain.result;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class ResultTest {

    @DisplayName("빈 Result를 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    @NullSource
    void validateEmpty(String input) {
        Assertions.assertThatThrownBy(() -> new Result(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 빈 결과를 입력할 수 없습니다.");
    }
}
