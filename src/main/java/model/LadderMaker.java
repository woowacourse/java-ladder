package model;

import java.util.Objects;
import strategy.PassGenerator;

public class LadderMaker {

    private final PassGenerator generator;
    private Ladder ladder;

    public LadderMaker(PassGenerator generator) {
        this.generator = generator;
    }

    public void initLadder(Height height, int totalParticipantSize) {
        ladder = Ladder.of(generator, height, totalParticipantSize);
    }

    public Ladder findLadder() {
        if (Objects.isNull(ladder)) {
            throw new IllegalStateException("사다리가 생성되지 않았습니다.");
        }
        return ladder;
    }
}
