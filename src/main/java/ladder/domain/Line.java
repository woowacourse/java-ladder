package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static ladder.constant.ErrorMessage.CONTINUE_SCAFFOLD;

public class Line {
    private final List<Boolean> scaffold;

    public Line(List<Boolean> scaffold) {
        this.scaffold = new ArrayList<>(scaffold);
        validateContinue(this.scaffold);
    }

    private static void validateContinue(List<Boolean> scaffold) {
        if (IntStream.range(0, scaffold.size() - 1)
                .anyMatch(i -> scaffold.get(i) && scaffold.get(i + 1))) {
            throw new IllegalArgumentException(CONTINUE_SCAFFOLD.generate());
        }
    }

    public List<Boolean> getScaffold() {
        return List.copyOf(scaffold);
    }
}
