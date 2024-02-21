package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LadderFactoryTest {

    static class TestLadderStrategy implements LadderStrategy {

        @Override
        public boolean creatable() {
            return true;
        }
    }

    ;

    @Test
    @DisplayName("사다리가 정상적으로 생성되는가")
    void valid_ladder_create_test() {
        // given
        final int width = 3, height = 1;
        LadderStrategy ladderStrategy = new TestLadderStrategy();
        LadderFactory ladderFactory = new LadderFactory(ladderStrategy);

        // when
        List<Bridge> bridges = ladderFactory.create(width, height);

        // then
        List<Bridge> expected = List.of(new Bridge(0, 1, 0));
        assertThat(expected).containsExactlyInAnyOrderElementsOf(bridges);
    }

}
