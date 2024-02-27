import static org.assertj.core.api.Assertions.assertThat;

import domain.Ladder;
import domain.LadderGame;
import domain.Line;
import domain.Player;
import domain.Players;
import domain.Prize;
import domain.Prizes;
import domain.Step;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class LadderGameTest {
    /*
   a  b  c  d
   |--|  |  |
   |--|  |--|
   |  |  |  |
   A  B  C  D
    */
    @Test
    void getPlayersWithPrize() {
        // given
        Ladder ladder = new Ladder(List.of(
                new Line(List.of(Step.EXIST, Step.EMPTY, Step.EMPTY, Step.EMPTY)),
                new Line(List.of(Step.EXIST, Step.EMPTY, Step.EXIST, Step.EMPTY)),
                new Line(List.of(Step.EMPTY, Step.EMPTY, Step.EMPTY, Step.EMPTY))
        ));
        Prize prizeA = new Prize("A");
        Prize prizeB = new Prize("B");
        Prize prizeC = new Prize("C");
        Prize prizeD = new Prize("D");
        Players players = Players.from(List.of("a", "b", "c", "d"));
        Prizes prizes = new Prizes(List.of(prizeA, prizeB, prizeC, prizeD));
        LadderGame ladderGame = new LadderGame(ladder, players, prizes);

        // when & then
        assertThat(ladderGame.getPlayersWithPrize()).containsExactlyInAnyOrderEntriesOf(Map.of(
                new Player("a"), prizeA,
                new Player("b"), prizeB,
                new Player("c"), prizeD,
                new Player("d"), prizeC
        ));
    }
}
