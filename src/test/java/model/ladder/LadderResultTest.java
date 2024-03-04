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
            () -> assertEquals(ladderResult.findValue(0), 3),
            () -> assertEquals(ladderResult.findValue(1), 0),
            () -> assertEquals(ladderResult.findValue(2), 1),
            () -> assertEquals(ladderResult.findValue(3), 2)
        );
    }

    private Ladder prepareLadder() {
        return new Ladder(List.of(
            Line.of(List.of(UNCONNECTED, CONNECTED, UNCONNECTED)),
            Line.of(List.of(CONNECTED, UNCONNECTED, UNCONNECTED)),
            Line.of(List.of(UNCONNECTED, CONNECTED, UNCONNECTED)),
            Line.of(List.of(CONNECTED, UNCONNECTED, CONNECTED)),
            Line.of(List.of(UNCONNECTED, UNCONNECTED, UNCONNECTED))
        ));
    }
}
