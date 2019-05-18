package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LadderResult {
    private List<Integer> result;

    public LadderResult(List<Integer> result) {
        this.result = result;
    }

    public List<String> match(List<String> items) {
        List<String> ladderResult = new ArrayList<>();

        for (int index : result) {
            ladderResult.add(items.get(index));
        }

        return ladderResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
