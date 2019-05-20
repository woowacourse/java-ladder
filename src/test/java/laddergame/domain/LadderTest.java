package laddergame.domain;

import laddergame.domain.rule.AlwaysCreateRule;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    void 사다리가_제대로_생성되었는지_확인() {
        Ladder ladder = new Ladder(2, 5, new AlwaysCreateRule());
        Line line = new Line(Arrays.asList(
                new Point(false, true),
                new Point(true, false)));
        List<Line> lines = new ArrayList<>(Arrays.asList(line, line, line, line, line));

        assertThat(ladder).isEqualTo(new Ladder(lines));
    }

    @Test
    void 사다리를_타고_제대로_내려가는지_확인() {
        Ladder ladder = new Ladder(2, 5, new AlwaysCreateRule());

        assertThat(ladder.takeLadder(0)).isEqualTo(1);
        assertThat(ladder.takeLadder(1)).isEqualTo(0);
    }

    @Test
    void 게임이_올바르게_진행되는지_테스트() {
        Players players = new Players(Arrays.asList("pobi", "cu"));
        Rewards rewards = new Rewards(Arrays.asList("1000", "100"));
        Ladder ladder = new Ladder(2, 5, new AlwaysCreateRule());

        LadderGameResult ladderGameResult = ladder.startGame(players, rewards);

        assertThat(ladderGameResult.result("pobi").getName()).isEqualTo("100");
        assertThat(ladderGameResult.result("cu").getName()).isEqualTo("1000");
    }
}