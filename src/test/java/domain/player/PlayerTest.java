package domain.player;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @DisplayName("플레이어의 초기 위치는 0이다.")
    @Test
    void playerInitPositionIsZero() {
        Player player = new Player("pobi");
        Assertions.assertThat(player.getPosition())
                .isEqualTo(new Position(0));
    }
}
