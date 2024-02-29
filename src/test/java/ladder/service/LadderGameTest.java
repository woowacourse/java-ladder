package ladder.service;

import static ladder.model.LadderPath.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import ladder.model.LadderPath;
import ladder.model.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {
    @Test
    @DisplayName("사다리의 가로줄 한 줄을 내려온 결과는 연결된 두 지점의 자리를 바꾼 것과 같다.")
    void climbDownOneLineTest() {
        LadderGame ladderGame = new LadderGame();
        List<Integer> initialPosition = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6));
        List<LadderPath> row = List.of(RIGHT, LEFT, RIGHT, LEFT, STAY, RIGHT, LEFT);
        List<Integer> expectedPosition = List.of(1, 0, 3, 2, 4, 6, 5);
        Line line = new Line(row);

        assertThat(ladderGame.climbDownOneLine(initialPosition, line))
                .isEqualTo(expectedPosition);
    }
}
