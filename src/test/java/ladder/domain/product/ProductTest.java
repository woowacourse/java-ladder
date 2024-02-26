package ladder.domain.product;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
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

    @DisplayName("이름은 적어도 1글자 이상 있어야 한다")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\n"})
    void validateTest_WhenNameIsEmpty_ThrowException(String name) {

        assertThatThrownBy(() -> new Product(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품 이름은 적어도 1글자 이상이어야 합니다.");
    }

    @DisplayName("이름이 1글자 이상 5글자 이하일 때, 정상적으로 객체를 생성한다")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "steve", "j"})
    void validateTest(String name) {

        assertThatCode(() -> new Product(name))
                .doesNotThrowAnyException();
    }
}
