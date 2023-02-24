package domain.ladder;

import domain.player.Position;
import java.util.List;
import java.util.stream.Stream;

public class LadderResults {

    private final List<LadderResult> ladderResults;

    private LadderResults(List<LadderResult> ladderResults) {
        this.ladderResults = ladderResults;
    }

    public static LadderResults createWithSameSize(List<LadderResult> ladderResults,
                                                   int size) {
        if (ladderResults.size() != size) {
            throw new IllegalArgumentException("크기가 일치하지 않습니다.");
        }

        return new LadderResults(ladderResults);
    }

    public LadderResult findResultByPosition(Position position) {
        return ladderResults.get(position.getPosition() - 1);
    }

    public Stream<LadderResult> stream() {
        return ladderResults.stream();
    }
}
