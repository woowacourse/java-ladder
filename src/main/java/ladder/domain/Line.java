package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

// TODO: Record 사용 고려
public class Line {
    private final List<Boolean> scaffold;

    public Line(List<Boolean> scaffold) {
        this.scaffold = new ArrayList<>(scaffold);
        validateContinue(this.scaffold);
    }

    private static void validateContinue(List<Boolean> scaffold) {
        if (IntStream.range(0, scaffold.size() - 1)
                .anyMatch(i -> scaffold.get(i) && scaffold.get(i + 1))) {
            throw new IllegalArgumentException("[ERROR] 좌우 연속해서 발판이 존재할 수 없습니다.");
        }
    }

    public List<Boolean> getScaffold() {
        return List.copyOf(scaffold);
    }
}
