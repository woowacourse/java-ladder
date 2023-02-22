package domain.product;

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
}