package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PrizesTest {

    @Test
    @DisplayName("플레이어 수와 같은 개수의 선물이 입력되었을 때에만 생성된다.")
    void createPrizes() {
        List<String> prizeInputNames = List.of("꽝", "꽝", "1등");
        int playerCount = 3;

        assertDoesNotThrow(() -> new Prizes(prizeInputNames, playerCount));
    }

}
