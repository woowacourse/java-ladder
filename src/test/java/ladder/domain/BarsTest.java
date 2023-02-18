package ladder.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BarsTest {

    @Test
    void 주어진_개수만큼_좌표값을_생성한다() {
        Bars bars = new Bars(new RandomPointGenerator(), 5);

        assertThat(bars.toUnmodifiableBars()).hasSize(5);
    }

    @Test
    void 좌표값은_랜덤하게_생성된다() {

        List<Boolean> expected = List.of(true, false, true, false, true);

        Queue<Boolean> queue = new LinkedList<>(expected);

        Bars bars = new Bars(new MockedPointGenerator(queue), 5);

        assertThat(bars.toUnmodifiableBars()).isEqualTo(expected);

    }

    private class MockedPointGenerator implements RandomGenerator {

        private final Queue<Boolean> queue;

        MockedPointGenerator(Queue<Boolean> queue) {
            this.queue = queue;
        }

        @Override
        public Boolean generate(boolean before) {
            return queue.poll();
        }
    }


}
