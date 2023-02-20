package laddergame.domain.ladder;

import laddergame.domain.rung.Rungs;
import laddergame.util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Rungs> ladderRungs;

    private Ladder(final List<Rungs> ladderRungs) {
        this.ladderRungs = ladderRungs;
    }

    public static Ladder create(final String height, final int participantCount, final BooleanGenerator rungGenerator) {
        List<Rungs> ladderRungs = LadderFactory
                .getInstance(rungGenerator)
                .createLadderRungs(height, participantCount);
        return new Ladder(ladderRungs);
    }

    public List<Integer> startGame(final int participantCount) {
        List<Integer> finalPositions = new ArrayList<>();
        for (int participantOrder = 0; participantOrder < participantCount; participantOrder++) {
            int currentRungPosition = participantOrder;
            currentRungPosition = getFinalRungPosition(currentRungPosition);
            finalPositions.add(currentRungPosition);
        }
        return finalPositions;
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
