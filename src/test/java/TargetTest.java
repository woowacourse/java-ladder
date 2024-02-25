import domain.Target;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TargetTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "baekho"})
    @DisplayName("결과의 글자 수가 1~5자가 아니면 예외를 발생시킨다.")
    void invalidResult(String result) {
        assertThatThrownBy(() -> new Target(result))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
