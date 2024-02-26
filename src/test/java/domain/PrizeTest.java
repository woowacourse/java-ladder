package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PrizeTest {

    @DisplayName("1글자 미만, 5글지 초과면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    void createFail(String input) {
        assertThatCode(() -> new Prize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("1글자 이상 5글자 이하의 값을 입력해주세요. 입력한 값 : %s", input));
    }
}
