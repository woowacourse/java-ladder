package domain.prize;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PrizeTest {
    @Nested
    @DisplayName("당첨 항목 생성 테스트")
    class MakePrizeTest {
        @DisplayName("입력값을 통해 올바르게 당첨 항목이 생성되는지 확인한다.")
        @ParameterizedTest
        @ValueSource(strings = {"꽝", "5000", "꽝", "3000", "mango"})
        void shouldSuccessMakePrize(String prizeName) {
            assertDoesNotThrow(() -> new Prize(prizeName));
        }
    }
}
