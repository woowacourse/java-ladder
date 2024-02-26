package domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PrizeTest {

    @DisplayName("객체가 정상적으로 생성된다.")
    @Test
    void constructSuccessTest(){
        assertThatNoException()
                .isThrownBy(() -> new Prize("takan"));
    }

    @DisplayName("상품이 빈 값일 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void constructFailWithBlankName(String value) {
        assertThatThrownBy(() -> new Prize(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
