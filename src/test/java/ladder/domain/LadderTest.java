package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LadderTest {

    @Test
    void 사다리는_주어진_높이만큼의_라인을_가진다() {
        int height = 3;
        Ladder ladder = Ladder.of(3, height);
        List<Line> lines = ladder.toUnModifiableLines();

        assertThat(lines.size()).isEqualTo(height);
    }

    @Test
    void 사다리는_참여자_수_보다_1_작은_폭을_가진다() {
        int playerCount = 3;
        Ladder ladder = Ladder.of(playerCount, 3);
        List<Line> lines = ladder.toUnModifiableLines();
        Line line = lines.get(0);

        assertThat(line.size()).isEqualTo(playerCount - 1);
    }
}
