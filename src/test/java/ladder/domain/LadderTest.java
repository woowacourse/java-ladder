package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LadderTest {

    @Test
    void 사다리는_주어진_높이만큼의_라인을_가진다() {
        int height = 3;
        Ladder ladder = Ladder.of(3, new LadderHeight(height));
        List<Line> lines = ladder.toUnModifiableLines();

        assertThat(lines.size()).isEqualTo(height);
    }

    @Test
    void 사다리는_참여자_수_보다_1_작은_폭을_가진다() {
        int playerCount = 3;
        Ladder ladder = Ladder.of(playerCount, new LadderHeight(3));
        List<Line> lines = ladder.toUnModifiableLines();
        Line line = lines.get(0);

        assertThat(line.size()).isEqualTo(playerCount - 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    void 참여자_수가_2_미만이면_예외(int playerCount) {
        assertThatThrownBy(() -> Ladder.of(playerCount, new LadderHeight(3)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
