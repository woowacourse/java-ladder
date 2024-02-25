package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderResultTest {
    @Test
    @DisplayName("사다리를 실행한 결과를 계산한다.")
    void moveLadderTest() {
        List<Integer> bars = List.of(0, 1, 0, 2);
        LadderResult ladderResult = new LadderResult(List.of("a", "b", "c", "d"));

        LadderResult actual = ladderResult.moveThroughLadder(bars);
        LadderResult expected = new LadderResult(List.of("c", "b", "d", "a"));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("실행 결과 개수와 참여할 사람 이름 개수가 일치하지 않으면 예외가 발생한다.")
    void sameLengthTest() {
        Players players = Players.from(List.of("a", "b", "c"));
        LadderResult ladderResult = new LadderResult(List.of("0", "1", "2", "3"));

        assertThatThrownBy(() -> ladderResult.isSameLengthWithLadderPlayers(players.getSize()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과 개수가 참여할 사람 이름의 수와 일치하지 않습니다.");
    }
}
