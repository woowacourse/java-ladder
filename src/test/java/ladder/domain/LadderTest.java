package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LadderTest {
    @Test
    public void 도착점_구하기_success() {
        Ladder ladder = new LadderGenerator(new Width(5), new Height(4)).generateLadder();
        int startPosition = 0;
        assertThatNoException()
                .isThrownBy(() -> ladder.getEndPosition(startPosition));
    }

    @Test
    public void 도착점_구하기_fail() {
        Ladder ladder = new LadderGenerator(new Width(5), new Height(4)).generateLadder();
        int startPoint = 6;
        assertThatThrownBy(() -> ladder.getEndPosition(startPoint))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("사다리 시작점은 0이상 %d이하이어야합니다.", 5));
    }
}
