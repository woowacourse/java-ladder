package ladder.domain.product;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ProductTest {

    @DisplayName("이름은 5글자를 넘을 수 없다")
    @ParameterizedTest
    @ValueSource(strings = {"prices", "123 45", "12345 "})
    void validateTest_WhenNameIsOver5_ThrowException(String name) {

        assertThatThrownBy(() -> new Product(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품 이름은 5글자를 넘을 수 없습니다.");
    }
}
