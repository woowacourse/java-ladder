package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BarsTest {
    @Test
    @DisplayName("사다리 실행 플레이어 결과를 계산한다.")
    void calculatePlayerResultTest() {
        Bars bars = new Bars(List.of(0, 1, 0, 2));
        LadderResult ladderResult = new LadderResult(List.of("a", "b", "c", "d"));

        LadderResult actual = ladderResult.moveThroughLadder(bars.getBars());
        LadderResult expected = new LadderResult(List.of("c", "b", "d", "a"));

        assertThat(actual).isEqualTo(expected);
    }
}
