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

    public LadderLeg generateLadderLeg(LadderLeg previousLadderLeg, Direction direction) {
        return new LadderLeg(convertDirectionToLegPieceList(IntStream.range(0, height.toInt())
                                                                     .mapToObj(previousLadderLeg::hasRightDirectionAtIndex)
                                                                     .map(flag -> determineDirection(flag, direction))));
    }

    private Direction determineDirection(boolean prevRightDirectionFlag, Direction direction) {
        if (prevRightDirectionFlag) {
            return Direction.LEFT;
        }
        return direction;
    }

    private List<LadderLegPiece> convertDirectionToLegPieceList(Stream<Direction> directionStream) {
        return directionStream.map(LadderLegPiece::new)
                              .toList();
    }

}
