package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;

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

        assertThat(bars.toUnmodifiableBars()).containsExactly(true, false, true, false, true);

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
