package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class LadderTest {

    @Test
    void getLadder() {
        Queue<Boolean> randomNumber = new LinkedList<>();
        Arrays.asList(true, true, false).forEach(randomNumber::add);
        Ladder ladder = new Ladder(5, new CustomRandomGenerator(randomNumber));

        Assertions.assertThat(ladder.getLadder())
                .isEqualTo(Arrays.asList(Position.LEFT, Position.RIGHT, Position.LEFT, Position.RIGHT, Position.DOWN));
    }
}
