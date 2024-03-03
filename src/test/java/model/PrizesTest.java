package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizesTest {

    @Test
    @DisplayName("참가자의 수와 다른 수의 경품을 입력하면 예외를 발생시킨다.")
    void IllegalLengthPrizesTest() {
        assertThatThrownBy(() -> new Prizes("hello, world", 4))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
