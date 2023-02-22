package laddergame.domain.player;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PlayersTest {

    @Test
    void givenName_thenReturnPlayer() {
        // given
        final Players players = new Players(
                List.of(
                        Player.of("ethan", 0),
                        Player.of("coil", 1)
                ));

        // when
        final Player player = players.findPlayerByName("ethan");

        // then
        assertAll(
                () -> assertThat(player.getName()).isEqualTo("ethan"),
                () -> assertThat(player.getPosition()).isEqualTo(0)
        );
    }
}
