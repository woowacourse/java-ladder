package domain.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ProductsTest {
    @Test
    @DisplayName("상품 저장")
    void createProducts() {
        Products products = Products.generate(List.of("사과", "꽝"));
    }

    @Test
    @DisplayName("상품이 5개 초과일때 에러")
    void createProducts2() {
        List<String> products = List.of("사과", "꽝", "1000", "2000", "3000", "꽝");
        Assertions.assertThatThrownBy(() -> {
            Products.generate(products);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}