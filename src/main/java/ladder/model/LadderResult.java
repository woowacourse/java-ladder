package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderResult {
    private final List<String> ladderResult;

    public LadderResult(List<String> ladderResult) {
        this.ladderResult = new ArrayList<>(ladderResult);
    }

    public void isSameLengthWithLadderPlayers(int playerSize) {
        if (ladderResult.size() != playerSize) {
            throw new IllegalArgumentException("실행 결과 개수가 참여할 사람 이름의 수와 일치하지 않습니다.");
        }
    }

    public LadderResult moveThroughLadder(List<Integer> bars) {
        List<String> changedLadderResult = new ArrayList<>(ladderResult);

        bars.forEach(idx -> Collections.swap(changedLadderResult, idx, idx + 1));

        return new LadderResult(changedLadderResult);
    }

    public List<String> getLadderResult() {
        return Collections.unmodifiableList(ladderResult);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(ladderResult, that.ladderResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderResult);
    }
}
