package ladder.domain;

import static ladder.domain.Direction.RIGHT;
import static ladder.domain.Direction.STAY;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import ladder.domain.generator.DirectionGenerator;
import ladder.domain.generator.LineGenerator;
import ladder.domain.generator.TestDirectionGenerator;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    LineGenerator lineGenerator;
    Players players;
    Height height;

    @BeforeEach
    void generateData() {
        final ArrayList<Direction> directions =
                Lists.newArrayList(RIGHT, STAY, STAY, RIGHT, RIGHT, STAY, RIGHT, STAY, RIGHT, RIGHT);
        final DirectionGenerator directionGenerator = new TestDirectionGenerator(directions);

        lineGenerator = new LineGenerator(directionGenerator);
        players = new Players(List.of("pobi", "crong", "eddy"));
        height = new Height(5);
    }

    @Test
    @DisplayName("사다리 높이만큼 선을 생성한다.")
    void validLadder() {
        // when
        final Ladder ladder = new Ladder(lineGenerator, players, height);

        // then
        assertThat(ladder.getLines()).hasSize(5);
    }

    @Test
    @DisplayName("사다리 결과에 따라 이름과 결과가 올바르게 매칭된다.")
    void validMatchingNameAndResult() {
        // given
        final Players expected = new Players(List.of("pobi", "crong", "eddy"), List.of(2, 0, 1));

        // when
        final Ladder ladder = new Ladder(lineGenerator, players, height);
        final Players actual = ladder.movePlayers(players);

        // then
        assertThat(actual.getPositions()).isEqualTo(expected.getPositions());
    }
}
