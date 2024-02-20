package ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Line {
    public Line(List<Boolean> line) {
        validate(line);
    }

    private void validate(List<Boolean> line) {
        validateIsNotEmpty(line);
        validateIsNotOverlapped(line);
    }

    private void validateIsNotEmpty(List<Boolean> line) {
        if (line.isEmpty()) {
            throw new IllegalArgumentException("적어도 가로 라인이 하나이상 있어야 한다.");
        }
    }

    private void validateIsNotOverlapped(List<Boolean> line) {
        if (isRowLineOverlapped(line)) {
            throw new IllegalArgumentException("가로 라인이 이어지면 안된다.");
        }
    }

    private boolean isRowLineOverlapped(List<Boolean> line) {
        return IntStream.range(1, line.size())
                .anyMatch(i -> line.get(i) && line.get(i - 1));
    }
}
