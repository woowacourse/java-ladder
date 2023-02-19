package ladder.service;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Names;
import ladder.util.BooleanGenerator;

public class LadderGame {
    private final Names names;
    private final Height height;
    private final Ladder ladder;
    private final BooleanGenerator generator;

    public LadderGame(Names names, Height height, BooleanGenerator generator) {
        this.names = names;
        this.height = height;
        this.generator = generator;
        ladder = new Ladder();
    }

    public void run() {
        createLadder();
    }

    public Names getParticipants() {
        return names;
    }

    public Ladder getLadder() {
        return ladder;
    }

    private void createLadder() {
        for (int i = 0; i < height.getHeight(); i++) {
            ladder.addLine(new Line(names.size(), generator));
        }
    }
}
