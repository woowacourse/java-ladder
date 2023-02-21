package laddergame.domain.ladder;

import laddergame.domain.rung.Rungs;
import laddergame.util.BooleanGenerator;

import java.util.List;

public class Ladder {

    private final List<Rungs> ladderRungs;

    private Ladder(final List<Rungs> ladderRungs) {
        this.ladderRungs = ladderRungs;
    }

    public static Ladder create(final String height, final int participantCount, final BooleanGenerator rungGenerator) {
        List<Rungs> ladderRungs = LadderRungsFactory
                .getInstance(rungGenerator)
                .createLadderRungs(height, participantCount);
        return new Ladder(ladderRungs);
    }

    public Integer startGame(final int participantOrder) {
        int finalRungPosition = participantOrder;
        finalRungPosition = getFinalRungPosition(finalRungPosition);
        return finalRungPosition;
    }

    private int getFinalRungPosition(int currentRungPosition) {
        for (Rungs rungs : ladderRungs) {
            currentRungPosition = getNextRungPosition(currentRungPosition, rungs);
        }
        return currentRungPosition;
    }

    private int getNextRungPosition(int currentRungPosition, final Rungs rungs) {
        int prevRungPosition = currentRungPosition - 1;
        if (rungs.canMove(prevRungPosition)) {
            return --currentRungPosition;
        }
        int nextRungPosition = currentRungPosition;
        if (rungs.canMove(nextRungPosition)) {
            return ++currentRungPosition;
        }
        return currentRungPosition;
    }

    public List<Rungs> getLadderRungs() {
        return List.copyOf(ladderRungs);
    }
}
