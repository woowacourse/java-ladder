package support;

import domain.ladder.LadderRung;
import domain.ladder.LadderRungGenerator;
import java.util.List;
import java.util.stream.IntStream;

public class FixedLadderRungGenerator implements LadderRungGenerator {
    private final List<LadderRung> ladderRungs;
    private int index;

    public FixedLadderRungGenerator(List<LadderRung> ladderRungs) {
        validateContinuouslyConnected(ladderRungs);
        this.ladderRungs = ladderRungs;
    }

    private void validateContinuouslyConnected(List<LadderRung> ladderRungs) {
        IntStream.range(1, ladderRungs.size())
                .filter(i -> ladderRungs.get(i - 1).isConnected() && ladderRungs.get(i).isConnected())
                .findAny()
                .ifPresent(i -> {
                    throw new IllegalArgumentException("가로대가 연속적으로 연결되어 있습니다.");
                });
    }

    @Override
    public LadderRung generate() {
        LadderRung ladderRung = ladderRungs.get(index++);
        if (ladderRung.isConnected()) {
            index++;
        }
        return ladderRung;
    }
}
