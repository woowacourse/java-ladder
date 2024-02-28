package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PriceTest {
    @Test
    @DisplayName("상품을 생성하여 반환한다")
    void makePrice() {
        String priceName = "맥북";
        Price price = new Price(priceName);
        Assertions.assertThat(price.getPrice()).isEqualTo("맥북");
    }

    @DisplayName("상품 이름은 5글자를 넘을 수 없다")
    @ParameterizedTest
    @CsvSource({"steve!", "123 45", "123456"})
    void validateTest_WhenLengthIsOver5(String priceName) {

        assertThatThrownBy(() -> new Price(priceName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품 이름은 5글자를 넘을 수 없습니다.");
    }

    @DisplayName("상품 이름에 공백 또는 Null 이 오면 안된다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = " ")
    void validateTest_WhenNameIsEmpty(String priceName) {
        assertThatThrownBy(() -> new Price(priceName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품 이름은 한글자 이상이어야 합니다.");
    }
}
