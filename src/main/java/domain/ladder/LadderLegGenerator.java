package domain.ladder;

import domain.ladder.attirbute.Direction;
import domain.ladder.attirbute.Height;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderLegGenerator {

    private final Height height;

    public LadderLegGenerator(Height height) {
        this.height = height;
    }

    public LadderLeg generateDownLadderLeg() {
        return new LadderLeg(convertDirectionToLegPieceList(IntStream.range(0, height.toInt())
                                                                     .mapToObj(index -> Direction.DOWN)));
    }

    public LadderLeg generateLadderLeg(LadderLeg previousLadderLeg, Supplier<Direction> directionSupplier) {
        return new LadderLeg(convertDirectionToLegPieceList(IntStream.range(0, height.toInt())
                                                                     .mapToObj(previousLadderLeg::hasRightDirectionAtIndex)
                                                                     .map(flag -> determineDirection(flag, directionSupplier))));
    }

    private Direction determineDirection(boolean prevRightDirectionFlag, Supplier<Direction> directionSupplier) {
        if (prevRightDirectionFlag) {
            final Supplier<Direction> leftDirectionSupplier = () -> Direction.LEFT;
            return leftDirectionSupplier.get();
        }
        return directionSupplier.get();
    }

    private List<LadderLegPiece> convertDirectionToLegPieceList(Stream<Direction> directionStream) {
        return directionStream.map(LadderLegPiece::new)
                              .toList();
    }

}
