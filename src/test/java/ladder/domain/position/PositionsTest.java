package ladder.domain.position;

import ladder.domain.direction.Direction;
import ladder.domain.line.CustomLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PositionsTest {

    @DisplayName("Ladder 안에 한 개의 Line을 통해 Position을 계산한다.")
    @Test
    void newPositionsTestByOneLineLadder() {
        //given
        CustomLine customLine = new CustomLine();
        customLine.addCustomDirection(Direction.RIGHT);
        customLine.addCustomDirection(Direction.LEFT);

        int width = customLine.getLineLength();
        Positions nowPositions = new Positions(width);

        //when
        Positions nextPositions = nowPositions.calcPosition(customLine.getLine());

        //then
        assertThat(nextPositions.getPositions()).containsExactly(new Position(1), new Position(0));
    }
}