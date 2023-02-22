package laddergame.domain.prize;

import laddergame.domain.player.Names;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void whenFindPlayerNames_thenReturnNames() {
        // given
        final Players players = new Players(List.of(Player.of("ethan", 0), Player.of("coil", 1), Player.of("junPk", 2)));
        final Prizes prizes = new Prizes(List.of("1000", "5000", "10000"), 3);
        final Result result = new Result(players, prizes);

        // when
        final Names playerNames = result.findPlayerNames();

        // then
        assertThat(playerNames.getNames()).containsExactly("ethan", "coil", "junPk");
    }
}
