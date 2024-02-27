package ladder.domain.ladder;

import ladder.domain.generator.BooleanGenerator;
import ladder.domain.game.Players;
import ladder.mock.MockBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGeneratorTest {

    @Test
    @DisplayName("사다리를 생성할 수 있다.")
    void generate() {
        final BooleanGenerator booleanGenerator = new MockBooleanGenerator(List.of(true, false, true));
        final LadderGenerator ladderGenerator = new LadderGenerator(booleanGenerator);

        final Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        final Height height = new Height(1);
        final Ladder ladder = ladderGenerator.generate(players, height);

        final List<Line> lines = ladder.getLines();
        assertThat(lines).hasSize(1);

        final Line line = lines.get(0);
        final List<Rung> rungs = line.getRungs();
        assertThat(rungs).containsExactly(Rung.EXIST, Rung.EMPTY, Rung.EXIST);
    }
}
