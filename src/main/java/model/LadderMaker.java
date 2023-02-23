package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import strategy.PassGenerator;

public class LadderMaker {

    private final PassGenerator generator;
    private Ladder ladder;

    public LadderMaker(PassGenerator generator) {
        this.generator = generator;
    }

    public void initLadder(Height height, int totalParticipantSize) {
        List<Line> lines = new ArrayList<>();

        while (height.isContinueMakeLadder(lines.size())) {
            Line line = Line.of(totalParticipantSize, generator);
            lines.add(line);
        }
        ladder = new Ladder(lines);
    }

    public Ladder findLadder() {
        if (Objects.isNull(ladder)) {
            throw new IllegalStateException("사다리가 생성되지 않았습니다.");
        }
        return ladder;
    }
}
