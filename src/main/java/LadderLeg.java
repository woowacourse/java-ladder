import java.util.List;

public class LadderLeg {
    private final List<LadderPiece> ladderPieces;

    LadderLeg(final List<LadderPiece> ladderPieces) {
        this.ladderPieces = ladderPieces;
    }

    public boolean hasRightDirectionAtIndex(int index) {
        return ladderPieces.get(index)
                           .isRightDirection();
    }
}
