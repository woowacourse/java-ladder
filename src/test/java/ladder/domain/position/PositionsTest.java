package ladder.domain.position;

import ladder.domain.direction.Direction;
import ladder.domain.line.CustomLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class PositionsTest {

    static Stream<CustomLine> singleLineProvider() {
        CustomLine customLine1 = new CustomLine();
        customLine1.addCustomDirection(Direction.RIGHT);
        customLine1.addCustomDirection(Direction.LEFT);
        customLine1.addCustomDirection(Direction.RIGHT);
        customLine1.addCustomDirection(Direction.LEFT);

        return Stream.of(customLine1);
    }

    static Stream<List<CustomLine>> multipleLinesProvider() {
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

        return Stream.of(List.of(customLine1, customLine2, customLine3));
    }


    @DisplayName("한 개의 line을 통해 Position을 계산한다.")
    @ParameterizedTest
    @MethodSource("singleLineProvider")
    void newPositionsTestByOneLineLadder(CustomLine customLine) {
        //given
        int width = customLine.getLineLength();
        Positions nowPositions = new Positions(width);

        //when
        Positions nextPositions = nowPositions.calcPosition(customLine.getLine());

        //then
        assertThat(nextPositions.getPositions())
                .containsExactly(new Position(1),
                        new Position(0),
                        new Position(3),
                        new Position(2)
                );
    }

    @DisplayName("다수의 Line을 통해 Position을 계산한다.")
    @ParameterizedTest
    @MethodSource("multipleLinesProvider")
    void newPositionsTestByMultipleLineLadder(List<CustomLine> customLines) {
        //given
        int width = customLines.get(0).getLineLength();

        //when
        Positions finalPositions = new Positions(width);
        for (CustomLine customLine : customLines) {
            finalPositions = finalPositions.calcPosition(customLine.getLine());
        }

        //then
        assertThat(finalPositions.getPositions())
                .containsExactly(new Position(2),
                        new Position(0),
                        new Position(1)
                );
    }
}
