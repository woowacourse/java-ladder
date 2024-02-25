package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {

    @Test
    @DisplayName("정상적인 상은 예외를 던지지 않는가")
    void normal_prize_doesnt_throw_exception() {
        Assertions.assertThatCode(() -> new Prize("5000"))
                .doesNotThrowAnyException();
    }

}
