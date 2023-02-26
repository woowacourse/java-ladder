package ladder.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsTest {

    @Test
    @DisplayName("여러 개의 값을 입력받아 Result를 복수로 생성한다.")
    void shouldCreatePlayersWhenInputStrings() {
        String resultValuesRaw = "꽝,5000,당첨,재시도";
        assertDoesNotThrow(() -> new Results(resultValuesRaw));
    }
}