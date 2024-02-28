package ladder.domain.position;

import ladder.domain.direction.Direction;
import ladder.domain.line.CustomLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PositionsTest {

    @DisplayName("Ladder 안에 한 개의 Line을 통해 Position을 계산한다.")
    @Test
    void newPositionsTestByOneLineLadder() {
        CustomLine customLine = new CustomLine();
        customLine.addCustomDirection(Direction.RIGHT);
        customLine.addCustomDirection(Direction.LEFT);

        List<Position> position = new ArrayList<>();
        int width = 2;
        for (int i = 0; i < width; i++) {
            position.add(new Position(i));
        }

        Positions nextPositions = new Positions(position, customLine.getLine());

        for(Position position1 : nextPositions.getPositions()) {
            System.out.print(position1.getPosition());
        }
    }
}