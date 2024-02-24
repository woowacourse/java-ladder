package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {

    @Test
    @DisplayName("정상적인 상품 객체를 생성한다.")
    void createValidPrize() {
        Assertions.assertThatCode(() -> new Prize("꽝"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("같은 이름인 경우 같은 상품 객체이다.")
    void createSamePrize() {
        //given
        var prize1 = new Prize("10000");
        var prize2 = new Prize("10000");

        //when & then
        Assertions.assertThat(prize1).isEqualTo(prize2);
    }
}
