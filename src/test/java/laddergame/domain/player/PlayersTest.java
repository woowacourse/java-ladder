package laddergame.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PlayersTest {

    @Test
    @DisplayName("Position이 주어지면 해당 위치에 있는 플레이어가 반환된다.")
    void givenPosition_thenReturnPlayer() {
        // given
        final Players players = new Players(
                List.of(
                        Player.of("ethan", 0),
                        Player.of("coil", 1)
                ));

        // when
        final Player player = players.findPlayerByPosition(0);

        // then
        assertAll(
                () -> assertThat(player.getName()).isEqualTo("ethan"),
                () -> assertThat(player.getPosition()).isEqualTo(0)
        );
    }
}
