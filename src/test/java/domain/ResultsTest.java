package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ResultsTest {
    @Test
    @DisplayName("실행 결과의 개수는 참가자들의 수와 동일해야 한다.")
    void createResults() {
        assertThrows(IllegalArgumentException.class, () -> new Results(List.of("꽝", "5000"), 3));
    }
}