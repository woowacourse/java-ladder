package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ResultTest {
    @Test
    @DisplayName("실행 결과의 개수는 참가자들의 수와 동일해야 한다.")
    void createResult() {
        assertThrows(IllegalArgumentException.class, () -> new Result(List.of("꽝", "5000"), 3));
    }
}