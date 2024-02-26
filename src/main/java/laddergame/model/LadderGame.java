package laddergame.model;

import java.util.List;

public class LadderGame {
    private final LadderHeight ladderHeight;
    private final Participants participants;
    private final RandomGenerator generator;
    private final Ladder ladder = new Ladder();

    public LadderGame(LadderHeight ladderHeight, Participants participants, RandomGenerator generator) {
        this.ladderHeight = ladderHeight;
        this.participants = participants;
        this.generator = generator;
    }

    public Ladder createLadder() {
        List<List<Boolean>> booleans = generator.generateBooleans(ladderHeight.getHeight(), participants.getSize());
        ladder.generateLine(ladderHeight.getHeight(), participants.getSize(), booleans);
        return ladder;
    }
}
