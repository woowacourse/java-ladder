package domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {
    @Test
    @DisplayName("이름을 통해 사용자를 생성한다.")
    void createPlayer() {
        Name name = new Name("포비");

        Player player = new Player(name);
        assertEquals(player.name(), name);
    }
}
