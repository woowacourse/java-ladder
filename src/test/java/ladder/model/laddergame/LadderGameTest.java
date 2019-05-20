package ladder.model.laddergame;

import ladder.model.ladder.Ladder;
import ladder.model.ladder.Point;
import ladder.model.linepointsgenerator.impl.CustomLinePointsGenerator;
import ladder.model.player.Players;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    void 올바른_이름을_입력하면_결과를_가져온다() {
        LadderGame ladderGame = new LadderGame(new Players("bmo,conas".split(","))
                , new Ladder(new CustomLinePointsGenerator(Arrays.asList(new Point(true), new Point(false))), 2)
                , new LadderGameResult("1000,꽝".split(","), 2));

        assertThat(ladderGame.getResultByName("bmo")).isEqualTo("1000");
    }
}
