package ladder.domain;

import static ladder.domain.Direction.RIGHT;
import static ladder.domain.Direction.STAY;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import ladder.domain.generator.DirectionGenerator;
import ladder.domain.generator.LineGenerator;
import ladder.domain.generator.TestDirectionGenerator;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("사다리 높이만큼 선을 생성한다.")
    void validLadder() {
        final ArrayList<Direction> directions = Lists.newArrayList(
                RIGHT, STAY, STAY, RIGHT, RIGHT, STAY, RIGHT, STAY, RIGHT, RIGHT);
        final DirectionGenerator directionGenerator = new TestDirectionGenerator(directions);
        final LineGenerator lineGenerator = new LineGenerator(directionGenerator);
        final Height height = new Height(5);
        
        final Ladder ladder = new Ladder(lineGenerator, 4, height);

        assertThat(ladder.getLines()).hasSize(5);
    }
}
