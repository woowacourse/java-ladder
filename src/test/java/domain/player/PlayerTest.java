package domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    @DisplayName("플레이어가 사다리를 건널 때 마다 위치가 변경된다")
    void moveToTest() {
        // given
        Player player1 = new Player(new PlayerName("kaki"), 0);
        Player player2 = new Player(new PlayerName("pobi"), 1);

        // when
        player1.moveTo(1);
        player2.moveTo(-1);

        // then
        assertAll(
                () -> assertThat(player1.getPosition()).isEqualTo(1),
                () -> assertThat(player2.getPosition()).isEqualTo(0)
        );
    }
}
