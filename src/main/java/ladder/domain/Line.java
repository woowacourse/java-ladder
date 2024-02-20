package ladder.domain;

import java.util.List;

public class Line {
    public Line(List<Boolean> line) {
        validate(line);
    }

    private void validate(List<Boolean> line) {
        if (line.isEmpty()) {
            throw new IllegalArgumentException("적어도 가로 라인이 하나이상 있어야 한다.");
        }
    }
}
