package ladder.model.laddergame;

import ladder.model.ladder.Ladder;
import ladder.model.ladder.Point;
import ladder.model.linepointsgenerator.impl.CustomLinePointsGenerator;
import ladder.model.player.Players;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    void 올바른_이름을_입력하면_결과를_가져온다() {
        LadderGame ladderGame = new LadderGame(new Players(Arrays.stream("bmo,conas".split(",")).collect(Collectors.toList()))
                , new Ladder(new CustomLinePointsGenerator(Arrays.asList(new Point(true))), 1)
                , new LadderGameResult(Arrays.stream("꽝,1000".split(",")).collect(Collectors.toList()), 2));

        ladderGame.playGame();
        assertThat(ladderGame.getResultByName("bmo")).isEqualTo("1000");
    }
}
