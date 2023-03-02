package ladder.domain;

import static ladder.domain.Direction.RIGHT;
import static ladder.domain.Direction.STAY;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.util.generator.DirectionGenerator;
import ladder.util.generator.TestDirectionGenerator;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {

    private Players players;
    private Ladder ladder;
    private Prizes prizes;

    @BeforeEach
    void setUp() {
        players = Players.from(List.of("pobi", "crong"));
        final Height height = new Height(2);
        final DirectionGenerator directionGenerator = new TestDirectionGenerator(Lists.newArrayList(RIGHT, STAY));
        ladder = Ladder.of(directionGenerator, players, height);
        prizes = Prizes.from(List.of("꽝", "3000"), players);
    }

    @Test
    @DisplayName("사다리 결과를 확인한다.")
    void should_get_result() {
        final LadderGame ladderGame = new LadderGame(players, ladder, prizes);

        final LadderResult ladderResult = ladderGame.getResult();

        assertThat(ladderResult.extract("pobi")).isEqualTo("3000");
        assertThat(ladderResult.extract("crong")).isEqualTo("꽝");
    }
}
