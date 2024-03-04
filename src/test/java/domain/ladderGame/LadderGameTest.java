package domain.ladderGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import domain.booleanGenerator.BooleanGenerator;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.player.Name;
import domain.player.Player;
import domain.player.Players;
import java.util.List;
import org.junit.jupiter.api.Test;
import support.TrueGenerator;

public class LadderGameTest {
    private final BooleanGenerator trueGenerator = new TrueGenerator();

    @Test
    void 각_플레이어는_사다리를_타고_이동한다() {
        // given
        Height height = new Height(3);
        Players players = new Players(List.of(
                new Player(new Name("name1"), 0),
                new Player(new Name("name2"), 1),
                new Player(new Name("name3"), 2),
                new Player(new Name("name4"), 3)
        ));

        /*
         *  |=====|     |=====|
         *  |=====|     |=====|
         *  |=====|     |=====|
         */
        Ladder ladder = new Ladder(trueGenerator, height, players.getPlayerCount());
        final LadderGame ladderGame = new LadderGame(ladder, players);

        // when
        ladderGame.play();

        // then
        assertAll(
                () -> assertThat(players.findPlayerByIndex(0).getPosition()).isEqualTo(1),
                () -> assertThat(players.findPlayerByIndex(1).getPosition()).isEqualTo(0),
                () -> assertThat(players.findPlayerByIndex(2).getPosition()).isEqualTo(3),
                () -> assertThat(players.findPlayerByIndex(3).getPosition()).isEqualTo(2)
        );
    }
}
