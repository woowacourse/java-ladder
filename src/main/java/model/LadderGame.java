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
            throw new IllegalArgumentException("[ERROR] 사다리 높이는 1 이상의 정수이어야 한다.");
        }
    }

    public Ladder createLadder() {
        return new Ladder(ladderHeight, participants.getSize(), generator);
    }
}
