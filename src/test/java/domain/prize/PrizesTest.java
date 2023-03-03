package domain.prize;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PrizesTest {
    @Nested
    @DisplayName("Prizes 생성 테스트")
    class MakePrizesTest {
        @DisplayName("입력값을 통해 올바르게 당첨 항목 리스트가 생성되는지 확인한다.")
        @Test
        void shouldSuccessMakePrizes() {
            assertDoesNotThrow(() -> new Prizes(List.of("꽝", "3000", "0", "mango"), 4));
        }

        @DisplayName("입력받은 Prize 수와 User 수가 다르면 Prizes 생성에 실패한다.")
        @Test
        void shouldFailMakePrizesIncorrectSize() {
            assertThatThrownBy(() -> new Prizes(List.of("꽝", "3000", "0", "mango"), 5))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Prizes.PRIZE_SIZE_ERROR_MESSAGE);
        }
    }
}
