package model;

public class LadderGame {

    private final int ladderHeight;
    private final Participants participants;
    private final RandomGenerator generator;

    public LadderGame(int ladderHeight, Participants participants, RandomGenerator generator) {
        validateLadderHeightRange(ladderHeight);
        this.ladderHeight = ladderHeight;
        this.participants = participants;
        this.generator = generator;
    }

    private void validateLadderHeightRange(int ladderHeight) {
        if (ladderHeight < 1) {
            throw new IllegalArgumentException();
        }
    }

    public Ladder createLadder() {
        Ladder ladder = new Ladder();
        ladder.generateLine(ladderHeight, participants.getSize(), generator);
        return ladder;
    }
}
