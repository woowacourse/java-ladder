package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import domain.booleanGenerator.BooleanGenerator;
import org.junit.jupiter.api.Test;
import support.TrueGenerator;

public class LadderTest {
    private final BooleanGenerator trueGenerator = new TrueGenerator();

    @Test
    void 주어진_높이에_맞게_사다리가_생성된다() {
        // given
        Height height = new Height(5);
        int playerCount = 5;

        // when
        Ladder ladder = new Ladder(trueGenerator, height, playerCount);

        // then
        assertThat(ladder.getLadderRows().size()).isEqualTo(height.getValue());
    }
}
