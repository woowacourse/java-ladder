package domain.ladder;

import domain.ladder.attirbute.Direction;

import java.util.List;

public class LadderLeg {
    private final List<LadderLegPiece> ladderLegPieces;

    public LadderLeg(final List<LadderLegPiece> ladderLegPieces) {
        this.ladderLegPieces = ladderLegPieces;
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
