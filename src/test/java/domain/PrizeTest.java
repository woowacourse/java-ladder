package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("결과는 ")
class PrizeTest {

    @DisplayName("앞 뒤 공백을 제외하고 1~5 글자이다")
    @ParameterizedTest
    @ValueSource(strings = {"a b c", "abcde", "연어", "a"})
    void eachResultLength1_5(String result) {
        assertDoesNotThrow(() -> new Prize(result));
    }

    @DisplayName("앞 뒤 공백을 제외하고 1~5 글자가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {" hi  hi   hi", "abcdefg", "", "     "})
    void eachResultLengthNot1_5(String result) {
        assertThatThrownBy(() -> new Prize(result))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 결과는 1 ~ 5 글자만 가능합니다");
    }

}