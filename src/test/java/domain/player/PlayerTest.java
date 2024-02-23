package domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;


public class PlayerTest {
    @Test
    @DisplayName("이름을 통해 사용자를 생성한다.")
    public void createPlayer() {
        Name name = new Name("포비");

        assertThatCode(() -> new Player(name))
                .doesNotThrowAnyException();
    }
}
