package model;

public class LadderGame {

    private final LadderHeight ladderHeight;
    private final Participants participants;
    private final RandomGenerator generator;

    public LadderGame(LadderHeight ladderHeight, Participants participants, RandomGenerator generator) {
        this.ladderHeight = ladderHeight;
        this.participants = participants;
        this.generator = generator;
    }

    public Ladder createLadder() {
        Ladder ladder = new Ladder();
        ladder.generateLine(ladderHeight.getHeight(), participants.getSize(), generator);
        return ladder;
    }
}
