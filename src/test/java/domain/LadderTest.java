package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @DisplayName("사다리 한줄이 제대로 생성이 되는지 테스트 합니다.")
    @Test
    void getLadder() {
        Queue<Boolean> randomNumber = new LinkedList<>();
        Arrays.asList(true, true, false).forEach(randomNumber::add);
        Ladder ladder = new Ladder(5, new CustomRandomGenerator(randomNumber));

        assertThat(ladder.getLadder())
                .isEqualTo(Arrays.asList(Position.LEFT, Position.RIGHT, Position.LEFT, Position.RIGHT, Position.DOWN));
    }
}
