import domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "baekho"})
    @DisplayName("이름이 1~5자가 아니면 예외를 발생한다.")
    void invalidName(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Player(name));
    }
}
