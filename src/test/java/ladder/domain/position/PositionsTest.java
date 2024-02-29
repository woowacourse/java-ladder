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
        customLine.addCustomDirection(Direction.RIGHT);
        customLine.addCustomDirection(Direction.LEFT);

        int width = customLine.getLineLength();
        Positions nowPositions = new Positions(width);

        //when
        Positions nextPositions = nowPositions.calcPosition(customLine.getLine());

        //then
        assertThat(nextPositions.getPositions()).containsExactly(new Position(1), new Position(0), new Position(3), new Position(2));
    }

    @DisplayName("Ladder 안에 여러 개의 Line을 통해 Position을 계산한다.")
    @Test
    void newPositionsTestByMultipleLineLadder() {
        //given
        CustomLine customLine1 = new CustomLine();
        customLine1.addCustomDirection(Direction.RIGHT);
        customLine1.addCustomDirection(Direction.LEFT);
        customLine1.addCustomDirection(Direction.NEUTRAL);

        CustomLine customLine2 = new CustomLine();
        customLine2.addCustomDirection(Direction.NEUTRAL);
        customLine2.addCustomDirection(Direction.NEUTRAL);
        customLine2.addCustomDirection(Direction.NEUTRAL);

        CustomLine customLine3 = new CustomLine();
        customLine3.addCustomDirection(Direction.NEUTRAL);
        customLine3.addCustomDirection(Direction.RIGHT);
        customLine3.addCustomDirection(Direction.LEFT);

        int width = customLine1.getLineLength();
        Positions nowPositions = new Positions(width);

        //when
        Positions nextPositions1 = nowPositions.calcPosition(customLine1.getLine());
        Positions nextPositions2 = nextPositions1.calcPosition(customLine2.getLine());
        Positions nextPosition3 = nextPositions2.calcPosition(customLine3.getLine());

        //then 1 0 2 -> 2 0 1
        assertThat(nextPosition3.getPositions()).containsExactly(new Position(2), new Position(0), new Position(1));
    }
}