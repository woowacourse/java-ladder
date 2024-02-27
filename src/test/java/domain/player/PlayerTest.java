package domain.player;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("플레이어 이름과 이름이 같은지 비교한다.")
    public void isNameEqual() {
        Name name1 = new Name("도비");
        Name name2 = new Name("조이썬");

        Player player = new Player(name1);

        assertTrue(player.isNameEqual(name1));
        assertFalse(player.isNameEqual(name2));
    }
}
