package ladder.domain.ladder;

import ladder.FixedLineStrategy;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    @DisplayName("사다리는 플레이어의 결과를 리턴해야 한다.")
    void ladder_returnPlayerResult() {
        /*
          1    2    3    4
          |----|    |----|
          |    |----|    |
          |----|    |----|
          4    2    3    1
         */
        // 각 플레이어는 플레이어의 이름과 동일한 결과를 갖는다.
        // given
        Ladder ladder = new Ladder(3, List.of("4", "2", "3", "1"));
        ladder.assignLines(new FixedLineStrategy(List.of(List.of(true, false, true),
                List.of(false, true, false), List.of(true, false, true))), 3);
        Players players = new Players(List.of("1", "2", "3", "4"));

        // expected
        for(Player player: players.getPlayers()) {
            assertThat(ladder.getItemOfPlayer(player).getName())
                    .isEqualTo(player.getName().getValue());
        }
    }
}
