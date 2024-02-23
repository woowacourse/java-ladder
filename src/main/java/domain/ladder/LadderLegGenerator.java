package domain.ladder;

import domain.ladder.common.Direction;
import domain.ladder.common.Height;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderLegGenerator {

    private static final Supplier<Direction> downDirectionSupplier = () -> Direction.DOWN;
    private final Height height;

    public LadderLegGenerator(Height height) {
        this.height = height;
    }

    public LadderLeg generateDownLadderLeg() {
        return new LadderLeg(convertDirectionToLegPieceList(IntStream.range(0, height.getHeight())
                                                                     .mapToObj(index -> downDirectionSupplier.get())));
    }

    public LadderLeg generateLadderLeg(LadderLeg previousLadderLeg, Supplier<Direction> directionSupplier) {
        return new LadderLeg(convertDirectionToLegPieceList(IntStream.range(0, height.getHeight())
                                                                     .mapToObj(previousLadderLeg::hasRightDirectionAtIndex)
                                                                     .map(flag -> determineDirection(flag, directionSupplier))));
    }

    private Direction determineDirection(boolean prevRightDirectionFlag, Supplier<Direction> directionSupplier) {
        if (prevRightDirectionFlag) {
            return Direction.LEFT;
        }
        return directionSupplier.get();
    }

    private List<LadderLegPiece> convertDirectionToLegPieceList(Stream<Direction> directionStream) {
        return directionStream.map(LadderLegPiece::new)
                              .toList();
    }

}
