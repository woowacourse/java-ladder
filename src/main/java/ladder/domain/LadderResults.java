package ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderResults {

    private final List<LadderResult> ladderResults;

    public LadderResults(final List<LadderResult> ladderResults, final Players players) {
        validateSameSize(ladderResults, players);
        this.ladderResults = ladderResults;
    }

    private void validateSameSize(final List<LadderResult> ladderResults, final Players players) {
        if (ladderResults.size() != players.count()) {
            throw new IllegalArgumentException(
                    "인원수와 결과의 개수가 일치하지 않습니다: 인원수 %d개, 결과 %d개".formatted(
                            players.count(),
                            ladderResults.size()
                    ));
        }
    }

    public LadderResult get(int index) {
        if (index < 0 || index >= ladderResults.size()) {
            throw new IllegalStateException("잘못된 위치입니다: %d".formatted(index));
        }
        return ladderResults.get(index);
    }

    public List<LadderResult> getLadderResults() {
        return Collections.unmodifiableList(ladderResults);
    }
}
