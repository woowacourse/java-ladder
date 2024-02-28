package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PriceTest {
    @Test
    @DisplayName("상품을 생성하여 반환한다")
    void makePrice() {
        String priceName = "맥북";
        Price price = new Price(priceName);
        Assertions.assertThat(price.getPrice()).isEqualTo("맥북");
    }
}
