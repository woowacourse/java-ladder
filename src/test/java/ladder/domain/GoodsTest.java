package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class GoodsTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcd", "가꽝"})
    @DisplayName("상품에 꽝이나 숫자가 아닌 다른 문자가 들어오면 예외를 던진다.")
    void throwExceptionWhenNameIsStringExceptBoom(String value) {
        assertThatThrownBy(() -> new Goods(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품 이름은 꽝 혹은 숫자여야 합니다.");
    }

    @Test
    @DisplayName("상품에 숫자가 들어갈 경우, 길이가 2 미만이면 예외를 던진다.")
    void throwExceptionWhenNameLengthLessThanTwo() {
        assertThatThrownBy(() -> new Goods("1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품 이름은 2 이상 5 이하여야 합니다.");
    }

    @Test
    @DisplayName("상품에 숫자가 들어갈 경우, 길이가 5 초과이면 예외를 던진다.")
    void throwExceptionWhenNameLengthLargeThanFive() {
        assertThatThrownBy(() -> new Goods("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품 이름은 2 이상 5 이하여야 합니다.");
    }
}
