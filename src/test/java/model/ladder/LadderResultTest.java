package model.ladder;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import model.bridge.Bridge;
import model.line.Line;
import model.line.LineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResultTest {

    @DisplayName("사다리 실행 결과를 생성한다")
    @Test
    void testLadderResult() {
        LadderHeight ladderHeight = new LadderHeight(5);
        LadderWidth ladderWidth = LadderWidth.from(4);
        LineGenerator lineGenerator = new CustomLineGenerator();
        Ladder ladder = Ladder.of(ladderHeight, ladderWidth, lineGenerator);

        LadderResult ladderResult = LadderResult.from(ladder);

        assertAll(
            () -> assertEquals(ladderResult.getValue(0), 3),
            () -> assertEquals(ladderResult.getValue(1), 0),
            () -> assertEquals(ladderResult.getValue(2), 1),
            () -> assertEquals(ladderResult.getValue(3), 2)
        );
    }

    private static class CustomLineGenerator implements LineGenerator {

        private final List<Line> lines = List.of(
            new Line(List.of(Bridge.UNCONNECTED, Bridge.CONNECTED, Bridge.UNCONNECTED)),
            new Line(List.of(Bridge.CONNECTED, Bridge.UNCONNECTED, Bridge.UNCONNECTED)),
            new Line(List.of(Bridge.UNCONNECTED, Bridge.CONNECTED, Bridge.UNCONNECTED)),
            new Line(List.of(Bridge.CONNECTED, Bridge.UNCONNECTED, Bridge.CONNECTED)),
            new Line(List.of(Bridge.UNCONNECTED, Bridge.UNCONNECTED, Bridge.UNCONNECTED))
        );

        private int count = 0;

        @Override
        public Line generateLine(int width) {
            if (count >= lines.size()) {
                count = 0;
            }
            return lines.get(count++);
        }
    }
}
