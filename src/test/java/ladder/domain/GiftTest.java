package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class GiftTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcd", "가꽝"})
    @DisplayName("상품에 꽝이나 숫자가 아닌 다른 문자가 들어오면 예외를 던진다.")
    void throwExceptionWhenNameIsStringExceptBoom(String value) {
        assertThatThrownBy(() -> new Gift(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품 이름은 꽝 혹은 숫자여야 합니다.");
    }

    @Test
    @DisplayName("상품에 공백이 들어갈 경우 예외를 던진다.")
    void throwExceptionWhenNameLengthLessThanTwo() {
        assertThatThrownBy(() -> new Gift(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품 이름을 작성해야 합니다.");
    }

    @Test
    @DisplayName("상품에 숫자가 들어갈 경우, 길이가 5 초과이면 예외를 던진다.")
    void throwExceptionWhenNameLengthLargeThanFive() {
        assertThatThrownBy(() -> new Gift("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품 이름은 1 이상 5 이하여야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"    12345:12345", "12345    :12345", "    12345    :12345"}, delimiter = ':')
    @DisplayName("상품 이름 양끝에 공백이 들어가 있으면 공백을 삭제한다.")
    void trimGoodsBothEndsBlank(final String value, final String expected) {
        final Gift gift = new Gift(value);

        assertThat(gift.getName()).isEqualTo(expected);
    }
}
