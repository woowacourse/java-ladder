import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @DisplayName("생성 테스트")
    @Test
    void creatGame() {
        Assertions.assertThatCode(() -> new Game("아톰,산초"))
                .doesNotThrowAnyException();
    }
}
