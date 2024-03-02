package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import domain.booleanGenerator.BooleanGenerator;
import domain.player.Name;
import domain.player.Player;
import domain.player.Players;
import java.util.List;
import org.junit.jupiter.api.Test;
import support.TrueGenerator;

public class LadderRowTest {
    private final BooleanGenerator trueGenerator = new TrueGenerator();

    @Test
    void 플레이어_수만큼_가로대를_생성한다() {
        // given
        final int playerSize = 5;

        // when
        LadderRow ladderRow = new LadderRow(trueGenerator, playerSize);

        // then
        assertThat(ladderRow.getLadderPoints()).hasSize(playerSize);
    }

    @Test
    void 이전_가로대가_연결되어_있으면_가로대를_연속해서_놓을_수_없다() {
        // given
        final int playerSize = 4;

        // when
        LadderRow ladderRow = new LadderRow(trueGenerator, playerSize);

        // then
        List<DirectionalPoint> ladderPoint = ladderRow.getLadderPoints();
        assertAll(
                () -> assertThat(ladderPoint.get(0)).isEqualTo(DirectionalPoint.RIGHT),
                () -> assertThat(ladderPoint.get(1)).isEqualTo(DirectionalPoint.LEFT),
                () -> assertThat(ladderPoint.get(2)).isEqualTo(DirectionalPoint.RIGHT),
                () -> assertThat(ladderPoint.get(3)).isEqualTo(DirectionalPoint.LEFT)
        );
    }

    @Test
    void 각_플레이어는_가로대를_만나면_이동한다() {
        // given
        Players players = new Players(List.of(
                new Player(new Name("name1"), 0),
                new Player(new Name("name2"), 1),
                new Player(new Name("name3"), 2),
                new Player(new Name("name4"), 3)
        ));

        // |=====|     |=====|
        LadderRow ladderRow = new LadderRow(trueGenerator, players.getPlayerCount());

        // when
        ladderRow.playRow(players);

        // then
        assertAll(
                () -> assertThat(players.findPlayerByIndex(0).getPosition()).isEqualTo(1),
                () -> assertThat(players.findPlayerByIndex(1).getPosition()).isEqualTo(0),
                () -> assertThat(players.findPlayerByIndex(2).getPosition()).isEqualTo(3),
                () -> assertThat(players.findPlayerByIndex(3).getPosition()).isEqualTo(2)
        );
    }
}
