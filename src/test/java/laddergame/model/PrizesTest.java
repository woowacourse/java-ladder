package laddergame.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizesTest {
    @Test
    @DisplayName("split 테스트")
    void Should_Split_When_Input() {
        assertDoesNotThrow(() -> Prizes.from(List.of("10000", "1000", "30000")));
    }
}
