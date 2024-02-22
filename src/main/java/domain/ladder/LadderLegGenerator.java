package domain.ladder;

import domain.ladder.common.Direction;
import domain.ladder.common.Height;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class LadderLegGenerator {

    private final Height height;

    public LadderLegGenerator(Height height) {
        this.height = height;
    }

    public LadderLeg generateDownLadderLeg() {
        return new LadderLeg(IntStream.range(0, height.getHeight())
                                      .mapToObj(index -> Direction.DOWN)
                                      .map(LadderLegPiece::new)
                                      .toList());
    }

    public LadderLeg generateLadderLeg(LadderLeg previousLadderLeg, Supplier<Direction> directionSupplier) {
        return new LadderLeg(convertDirectionToLegPieceList(IntStream.range(0, height.getHeight())
                                                        .mapToObj(previousLadderLeg::hasRightDirectionAtIndex)
                                                        .map(flag -> determineDirection(flag, directionSupplier))));
    }

}
