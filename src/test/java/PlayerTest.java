import domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {
    @Test
    @DisplayName("이름이 1~5자가 아니면 예외를 발생한다.")
    void invalidName() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Player("abcdef"));
    }
    @Test
    @DisplayName("이름이 1~5자이내면 예외를 발생하지 않는다.")
    void validName() {
        assertThatCode(() -> new Player("abcde")).doesNotThrowAnyException();
    }
}
