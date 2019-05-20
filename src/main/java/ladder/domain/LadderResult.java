package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderResult {
    private List<Integer> result;

    public LadderResult(List<Integer> result) {
        this.result = result;
    }

    public List<String> match(Items items) {
        return result.stream().map(items::getItemName).collect(Collectors.toList());
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
