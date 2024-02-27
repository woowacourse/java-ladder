import static org.assertj.core.api.Assertions.assertThat;

import domain.Height;
import domain.Ladder;
import domain.LadderGame;
import domain.Player;
import domain.PlayerCount;
import domain.Players;
import domain.PlayersPrize;
import domain.Prizes;
import java.util.List;
import mock.ExistStepGenerator;
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
    void getPlayersWithPrize() {
        // given
        Players players = Players.from(List.of("a", "b", "c", "d"));
        Prizes prizes = Prizes.from(List.of("A", "B", "C", "D"));
        Ladder ladder = Ladder.create(new Height(3), PlayerCount.fromPlayers(players), new ExistStepGenerator());
        LadderGame ladderGame = new LadderGame(ladder, players, prizes);

        // when
        PlayersPrize playersPrize = ladderGame.getPlayersPrize();

        // then
        assertThat(playersPrize.getPlayersPrize().get(new Player("a")).getPrize()).isEqualTo("B");
        assertThat(playersPrize.getPlayersPrize().get(new Player("b")).getPrize()).isEqualTo("A");
        assertThat(playersPrize.getPlayersPrize().get(new Player("c")).getPrize()).isEqualTo("D");
        assertThat(playersPrize.getPlayersPrize().get(new Player("d")).getPrize()).isEqualTo("C");
    }
}
