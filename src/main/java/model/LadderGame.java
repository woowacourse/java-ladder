package model;

public class LadderGame {

    private final Height ladderHeight;
    private final Participants participants;
    private final RandomGenerator generator;

    public LadderGame(Height ladderHeight, Participants participants, RandomGenerator generator) {
        this.ladderHeight = ladderHeight;
        this.participants = participants;
        this.generator = generator;
    }

    public Ladder createLadder() {
        return new Ladder(ladderHeight, participants.getSize(), generator);
    }
}
