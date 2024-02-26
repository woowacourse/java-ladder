package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LadderTest {

    @Test
    @DisplayName("사다리가 정상적으로 생성되는가")
    void valid_ladder_create_test() {
        // given
        final int width = 3, height = 1;
        final LadderStrategy ladderStrategy = new TestLadderStrategy();
        final Ladder ladder = new Ladder(ladderStrategy, width, height);

        // when
        final List<Bridge> bridges = ladder.getBridges();

        // then
        final List<Bridge> expected = List.of(new Bridge(0, 0));
        assertThat(expected).containsExactlyInAnyOrderElementsOf(bridges);
    }

    static class TestLadderStrategy implements LadderStrategy {
        @Override
        public boolean creatable() {
            return true;
        }
    }
}
