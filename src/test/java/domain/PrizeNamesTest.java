package domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.prize.PrizeName;
import domain.prize.PrizeNames;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeNamesTest {

    @Test
    @DisplayName("플레이어 수와 같은 개수의 선물이 입력되었을 때에만 생성된다.")
    void createPrizes() {
        List<String> prizeInputNames = List.of("꽝", "꽝", "1등");
        int playerCount = 3;

        assertDoesNotThrow(() -> new PrizeNames(prizeInputNames, playerCount));
    }

    @Test
    @DisplayName("플레이어 수와 다른 개수의 선물이 입력되었을 때에 예외를 던진다")
    void createWrongPrizes() {
        List<String> prizeInputNames = List.of("꽝", "꽝", "1등");
        int playerCount = 0;

        assertThrows(IllegalArgumentException.class, () -> new PrizeNames(prizeInputNames, playerCount));
    }

    @Test
    @DisplayName("특정 index에 존재하는 PrizeName을 반환한다.")
    void getPrizeNameInSpecificIndex() {
        List<String> prizeInputNames = List.of("꽝", "꽝", "1등");
        int playerCount = 3;
        PrizeNames prizeNames = new PrizeNames(prizeInputNames, playerCount);

        PrizeName expectedPrizeName = new PrizeName("1등");

        assertEquals(expectedPrizeName, prizeNames.getPrizeNameInIndex(2));
    }
}
