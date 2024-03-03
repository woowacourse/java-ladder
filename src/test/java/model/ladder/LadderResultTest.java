package model.ladder;

import static model.bridge.Bridge.CONNECTED;
import static model.bridge.Bridge.UNCONNECTED;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import model.line.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResultTest {

    @DisplayName("사다리 실행 결과를 생성한다")
    @Test
    void testLadderResult() {
        Ladder ladder = prepareLadder();
        LadderResult ladderResult = LadderResult.from(ladder);

        assertAll(
            () -> assertEquals(ladderResult.getValue(0), 3),
            () -> assertEquals(ladderResult.getValue(1), 0),
            () -> assertEquals(ladderResult.getValue(2), 1),
            () -> assertEquals(ladderResult.getValue(3), 2)
        );
    }

    private Ladder prepareLadder() {
        return new Ladder(List.of(
            new Line(List.of(UNCONNECTED, CONNECTED, UNCONNECTED)),
            new Line(List.of(CONNECTED, UNCONNECTED, UNCONNECTED)),
            new Line(List.of(UNCONNECTED, CONNECTED, UNCONNECTED)),
            new Line(List.of(CONNECTED, UNCONNECTED, CONNECTED)),
            new Line(List.of(UNCONNECTED, UNCONNECTED, UNCONNECTED))
        ));
    }
}
