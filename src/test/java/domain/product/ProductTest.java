package domain.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    @DisplayName("생성자 생성")
    void createProduct() {
        Product product = new Product("사탕");
    }
}