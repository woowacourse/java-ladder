package ladder.domain.product;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("해당 인덱스의 상품을 알 수 있다")
    @Test
    void getTest() {
        List<String> names = List.of("꽝", "3000", "꽝", "5000");
        Products products = Products.from(names);

        assertAll(
                () -> assertThat(products.get(0)).isEqualTo(new Product("꽝")),
                () -> assertThat(products.get(1)).isEqualTo(new Product("3000")),
                () -> assertThat(products.get(2)).isEqualTo(new Product("꽝")),
                () -> assertThat(products.get(3)).isEqualTo(new Product("5000"))
        );
    }

    @DisplayName("요청한 인덱스가 범위를 벗어날 경우, 예외를 던진다")
    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    void getTest_WhenIndexIsOutOfRange_ThrowException(int index) {
        List<String> names = List.of("꽝", "3000", "꽝", "5000");
        Products products = Products.from(names);

        assertThatThrownBy(() -> products.get(index))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("요청한 인덱스가 범위를 벗어났습니다.");
    }

    @DisplayName("총 상품 수를 알 수 있다")
    @Test
    void sizeTest() {
        List<String> names = List.of("꽝", "3000", "꽝", "5000");
        Products products = Products.from(names);

        int actual = products.size();

        assertThat(actual).isEqualTo(names.size());
    }
}
