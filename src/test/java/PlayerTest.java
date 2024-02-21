import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerTest {

    @DisplayName("플레이어 객체를 정상적으로 생성한다.")
    @Test
    void createPlayer() {
        assertThatCode(() -> new Player("dodo"))
                .doesNotThrowAnyException();
    }
}
