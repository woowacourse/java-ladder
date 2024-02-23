package domain.ladder;

import domain.ladder.common.Direction;
import domain.ladder.common.Height;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderLeg {
    private final List<LadderLegPiece> ladderLegPieces;

    public LadderLeg(final List<LadderLegPiece> ladderLegPieces) {
        this.ladderLegPieces = ladderLegPieces;
    }

    public static LadderLeg downLadderLeg(int height) {
        return new LadderLeg(convertDirectionToLegPieceList(IntStream.range(0, height)
                                                                     .mapToObj(index -> Direction.DOWN)));
    }

    public static LadderLeg from(LadderLeg previousLadderLeg, int height, Supplier<Direction> directionSupplier) {
        return new LadderLeg(convertDirectionToLegPieceList(IntStream.range(0, height)
                                                                     .mapToObj(previousLadderLeg::hasRightDirectionAtIndex)
                                                                     .map(flag -> determineDirection(flag, directionSupplier))));
    }

    private static Direction determineDirection(boolean prevRightDirectionFlag, Supplier<Direction> directionSupplier) {
        if (prevRightDirectionFlag) {
            return Direction.LEFT;
        }
        return directionSupplier.get();
    }

    private static List<LadderLegPiece> convertDirectionToLegPieceList(Stream<Direction> directionStream) {
        return directionStream.map(LadderLegPiece::new)
                              .toList();
    }

    public boolean hasRightDirectionAtIndex(int index) {
        return ladderLegPieces.get(index)
                              .isRightDirection();
    }

    public Direction getDirectionAtIndex(int index) {
        return ladderLegPieces.get(index)
                              .getDirection();
    }
}
