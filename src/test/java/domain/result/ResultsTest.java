package domain.result;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsTest {

    @Test
    @DisplayName("결과를 받아 올바르게 일급 컬렉션을 생성한다.")
    void validCreationTest() {
        List<String> results = List.of("1000", "꽝");
        assertDoesNotThrow(() -> new Results(results));
    }
}