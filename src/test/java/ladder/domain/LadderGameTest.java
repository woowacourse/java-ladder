package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {
    @Test
    @DisplayName("플레이어의 수와 상품의 수가 다르면 예외던지기")
    public void 플레이어수와_상품수가_다르면_예외던지기() {
        Players players = Players.from(List.of("a", "b"));
        Prizes prizes = Prizes.from(List.of("1", "2", "3"));
        Ladder ladder = new LadderGenerator(new Width(1), new Height(5)).generateLadder();

        assertThatThrownBy(() -> new LadderGame(players, prizes, ladder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어수와 상품수는 동일해야 합니다.");
    }
}
