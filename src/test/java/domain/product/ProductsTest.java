package domain.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductsTest {
    @Test
    @DisplayName("상품 저장")
    void createProducts() {
        Products products = new Products(List.of(new Product("사과"), new Product("꽝")));
    }

    @Test
    @DisplayName("상품이 5개 초과일때 에러")
    void createProducts2() {
        List<Product> products = (List.of(new Product("사과"), new Product("꽝"),
                new Product("1000"), new Product("2000"), new Product("3000"), new Product("꽝")));
        Assertions.assertThatThrownBy(() -> {
            new Products(products);
        }).isInstanceOf(IllegalArgumentException.class);
    }



}