package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderResultTest {

    @ParameterizedTest
    @ValueSource(strings = {"꽝", "5000", "꽝", "3000"})
    @DisplayName("실행 결과를 받아서 LadderResult를 생성한다.")
    void generateTest(String result) {
        Assertions.assertDoesNotThrow(() -> new LadderResult(result));
    }
}
