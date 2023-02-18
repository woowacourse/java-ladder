package ladder.domain.generator;

import static ladder.domain.Direction.RIGHT;
import static ladder.domain.Direction.STAY;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.Direction;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGeneratorTest {

    @Test
    @DisplayName("사다리 높이만큼 선을 생성한다.")
    void validLadder() {
        //given
        final ArrayList<Direction> directions = Lists.newArrayList(
                RIGHT, STAY, STAY, RIGHT, RIGHT, STAY, RIGHT, STAY, RIGHT, RIGHT);
        final var directionGenerator = new TestDirectionGenerator(directions);
        final var lineGenerator = new LineGenerator(directionGenerator);
        final var ladderGenerator = new LadderGenerator(lineGenerator);
        final Players players = new Players(List.of("pobi", "crong"));
        final Height height = new Height(5);

        //when
        Ladder ladder = ladderGenerator.generate(players, height);

        //then
        assertThat(ladder.getLines()).hasSize(5);
    }
}
