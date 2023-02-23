package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizesTest {

    @Test
    @DisplayName("상품의 수는 사람의 수와 같아야 한다")
    void validatePrizeCountTest() {
        int peopleCount = 3;

        assertThatThrownBy(() -> new Prizes(List.of("상품1", "상품2"), peopleCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Prizes.INVALID_COUNT_MESSAGE);
    }

    @Test
    @DisplayName("상품의 이름은 1자 이상 10자 이하여야 한다")
    void validateNameTest() {
        assertThatThrownBy(() -> new Prizes(List.of("", "상품2", "12345678901"), 3))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(
                String.format(Prizes.NAME_LENGTH_FORMAT, Prizes.MIN_LENGTH, Prizes.MAX_LENGTH));
    }
}
