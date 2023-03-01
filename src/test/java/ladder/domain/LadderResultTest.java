package ladder.domain;

import ladder.FixedLineStrategy;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderResultTest {
    private Ladder ladder;
    private Players players;

    @BeforeEach
    void setUp() {
        /*
          1    2    3    4
          |----|    |----|
          |    |----|    |
          |----|    |----|
          4    2    3    1
         */
        ladder = new Ladder(3, List.of("4", "2", "3", "1"));
        ladder.assignLines(new FixedLineStrategy(List.of(List.of(true, false, true),
                List.of(false, true, false), List.of(true, false, true))), 3);
        players = new Players(List.of("1", "2", "3", "4"));
    }

    @Test
    @DisplayName("플레이어는 하나의 결과를 갖는다.")
    void ladderResult_playerGetOneResult() {
        // given
        LadderResult ladderResult = new LadderResult(players, ladder);

        // expected
        Player player = players.findPlayerByName("1");
        assertThat(ladderResult.getItemOfPlayer(player).getName()).isEqualTo("1");
    }

    @Test
    @DisplayName("없는 플레이어의 결과를 가져오는 경우 예외를 던진다.")
    void ladderResult_throwException_notExistPlayer() {
        // given
        LadderResult ladderResult = new LadderResult(players, ladder);

        // expected
        assertThatThrownBy(() -> ladderResult.getItemOfPlayer(new Player("vero", 0)))
                .isInstanceOf(IllegalStateException.class);
    }
}
