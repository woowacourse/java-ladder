package domain.prize;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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
            List<Prize> prizes = new ArrayList<>();
            for (String prizeName : List.of("꽝", "3000", "0", "mango")) {
                prizes.add(new Prize(prizeName));
            }
            assertDoesNotThrow(() -> new Prizes(prizes, 4));
        }

        @DisplayName("입력받은 Prize 수와 User 수가 다르면 Prizes 생성에 실패한다.")
        @Test
        void shouldFailMakePrizesIncorrectSize() {
            List<Prize> prizes = new ArrayList<>();
            for (String prizeName : List.of("꽝", "3000", "0", "mango")) {
                prizes.add(new Prize(prizeName));
            }
            assertThatThrownBy(() -> new Prizes(prizes, 5))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Prizes.PRIZE_SIZE_ERROR_MESSAGE);
        }
    }
}
