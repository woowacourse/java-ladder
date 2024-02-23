package model;

public class LadderGame {
    private static final int MINIMUM_LADDER_HEIGHT = 1;

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
        if (ladderHeight < MINIMUM_LADDER_HEIGHT) {
            throw new IllegalArgumentException("[ERROR] 사다리 높이는 " + MINIMUM_LADDER_HEIGHT + " 이상의 정수이어야 한다.");
        }
    }

    public Ladder createLadder() {
        Ladder ladder = new Ladder();
        ladder.generateLine(ladderHeight, participants.getSize(), generator);
        return ladder;
    }
}
