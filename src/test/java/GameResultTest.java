import static org.assertj.core.api.Assertions.assertThat;

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

public class GameResultTest {
    /*
   a  b  c  d
   |--|  |--|
   |--|  |--|
   |--|  |--|
   A  B  C  D
    */
    @Test
    @DisplayName("참여자에 해당하는 실행 결과를 반환한다.")
    void validSearch() {
        // given
        final Players players = Players.from(List.of("a", "b", "c", "d"));
        final Prizes prizes = Prizes.from(List.of("A", "B", "C", "D"));
        final Ladder ladder = Ladder.create(new Height(3), PlayerCount.fromPlayers(players), new trueSupplier());

        // when
        final GameResult gameResult = GameResult.of(ladder, players, prizes);

        // then

        // when & then
        assertThat(gameResult.search(new Player("a")).getPrize()).isEqualTo("B");
    }
}
