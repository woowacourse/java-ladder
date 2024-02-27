package laddergame.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {
    @DisplayName("사다리 게임을 진행하여 최종 결과 인덱스를 반환한다.")
    @Test
    void climb() {
        List<Line> lines = List.of(
                new Line(List.of(LineState.START, LineState.END, LineState.NONE, LineState.NONE)),
                new Line(List.of(LineState.START, LineState.END, LineState.START, LineState.END)),
                new Line(List.of(LineState.NONE, LineState.START, LineState.END, LineState.NONE))
        );
        LadderGame ladderGame = new LadderGame(lines);

        assertAll(
                () -> assertThat(ladderGame.climb(0)).isEqualTo(0),
                () -> assertThat(ladderGame.climb(1)).isEqualTo(2),
                () -> assertThat(ladderGame.climb(2)).isEqualTo(3),
                () -> assertThat(ladderGame.climb(3)).isEqualTo(1)
        );
    }
}
