import domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {
    @Test
    @DisplayName("이름이 1~5자가 아니면 예외를 발생한다.")
    void validate() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Player("aaaaaa"));
    }
}
