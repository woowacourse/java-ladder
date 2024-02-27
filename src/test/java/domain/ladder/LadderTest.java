package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import domain.booleanGenerator.BooleanGenerator;
import domain.player.Name;
import domain.player.Players;
import java.util.List;
import org.junit.jupiter.api.Test;
import support.TrueGenerator;
import view.OutputView;

public class LadderTest {
    private final BooleanGenerator trueGenerator = new TrueGenerator();

    @Test
    void 주어진_높이에_맞게_사다리가_생성된다() {
        // given
        Height height = new Height(5);
        int playerSize = 5;

        // when
        Ladder ladder = new Ladder(trueGenerator, height, playerSize);

        // then
        assertThat(ladder.getHeight()).isEqualTo(height.getValue());
    }

    @Test
    void 각_플레이어는_사다리를_타고_이동한다() {
        // given
        Height height = new Height(3);
        Players players = new Players(List.of(
                new Name("name1"),
                new Name("name2"),
                new Name("name3"),
                new Name("name4")
        ));

        /*
         *  |=====|     |=====|
         *  |=====|     |=====|
         *  |=====|     |=====|
         */
        Ladder ladder = new Ladder(trueGenerator, height, players.getPlayerCount());
        OutputView.printLadder(ladder, 5);

        // when
        ladder.play(players);

        // then
        assertAll(
                () -> assertThat(players.findPlayerByIndex(0).getPosition()).isEqualTo(1),
                () -> assertThat(players.findPlayerByIndex(1).getPosition()).isEqualTo(0),
                () -> assertThat(players.findPlayerByIndex(2).getPosition()).isEqualTo(3),
                () -> assertThat(players.findPlayerByIndex(3).getPosition()).isEqualTo(2)
        );
    }
}
