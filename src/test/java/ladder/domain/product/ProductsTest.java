package ladder.domain.product;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductsTest {

    @DisplayName("상품은 적어도 2개 미만일 경우, 예외를 던진다")
    @Test
    void validateTest_WhenProductsIsUnder2_ThrowException() {
        List<String> names = List.of("꽝");

        assertThatThrownBy(() -> Products.from(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품은 적어도 2개 이상 있어야 합니다.");
    }

    @DisplayName("상품이 2개 이상 있을 경우, 정상적으로 객체를 생성한다")
    @Test
    void validateTest() {
        List<String> names = List.of("꽝", "3000");

        assertThatCode(() -> Products.from(names))
                .doesNotThrowAnyException();
    }
}
