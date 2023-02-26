package domain.prize;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PrizesTest {
    @Nested
    @DisplayName("Prizes 생성 테스트")
    class MakeUserTest {
        @DisplayName("입력값을 통해 올바르게 당첨 항목 리스트가 생성되는지 확인한다.")
        @Test
        void shouldSuccessMakePrizes() {
            List<Prize> prizes = new ArrayList<>();
            for (String prizeName : List.of("꽝", "3000", "0", "mango")) {
                prizes.add(new Prize(prizeName));
            }
            assertDoesNotThrow(() -> new Prizes(prizes));
        }
    }
}
