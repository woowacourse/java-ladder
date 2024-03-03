import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import domain.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    @DisplayName("이름이 1~5자가 아니면 예외를 발생한다.")
    void invalidName() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Player("abcdef"));
    }

    @Test
    @DisplayName("all이 입력된 경우 예외를 발생시킨다.")
    void allCommandName() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Player("all"));
    }

    @Test
    @DisplayName("이름이 1~5자 이내면 예외를 발생하지 않는다.")
    void validName() {
        assertThatCode(() -> new Player("abcde")).doesNotThrowAnyException();
    }
}
