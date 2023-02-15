import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LaddersTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 11})
    @DisplayName("사다리 높이가 1~10을 벗어나면 예외가 발생한다.")
    void LadderHeightFailTest(int height) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Ladders(height));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    @DisplayName("사다리 높이가 1~10 사이면 정상적으로 수행된다.")
    void LadderHeightSuccessTest(int height) {
        assertThatCode(() -> new Ladders(height)).doesNotThrowAnyException();
    }
}
