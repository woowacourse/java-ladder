import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.player.Player;
import domain.player.PlayerCount;
import domain.player.Players;
import domain.prize.Prizes;
import domain.result.GameResult;
import java.util.List;
import mock.trueSupplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {
    /*
   a  b  c  d
   |--|  |--|
   |--|  |--|
   |--|  |--|
   A  B  C  D
    */
    @Test
    @DisplayName("각 참가자에 대한 실행결과를 가져온다.")
    void getPlayersWithPrize() {
        // given
        final Players players = Players.from(List.of("a", "b", "c", "d"));
        final Prizes prizes = Prizes.from(List.of("A", "B", "C", "D"));
        final Ladder ladder = Ladder.create(new Height(3), PlayerCount.fromPlayers(players), new trueSupplier());

        // when
        final GameResult gameResult = GameResult.of(ladder, players, prizes);

        // then
        assertAll(
                () -> assertThat(gameResult.getPlayersPrize().get(new Player("a")).getPrize()).isEqualTo("B"),
                () -> assertThat(gameResult.getPlayersPrize().get(new Player("b")).getPrize()).isEqualTo("A"),
                () -> assertThat(gameResult.getPlayersPrize().get(new Player("c")).getPrize()).isEqualTo("D"),
                () -> assertThat(gameResult.getPlayersPrize().get(new Player("d")).getPrize()).isEqualTo("C")
        );
    }
}
