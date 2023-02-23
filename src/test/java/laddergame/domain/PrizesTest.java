package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrizesTest {
    @Test
    @DisplayName("Prizes가 정상적으로 생성된다.")
    void prizesCreateTest() {
        List<String> prizes = List.of("꽝", "5000", "꽝", "3000");
        assertDoesNotThrow(() -> new Prizes(prizes));
    }
}
