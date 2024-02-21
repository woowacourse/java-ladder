package ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Stick> line;

    public Line(List<Stick> line) {
        validate(line);

        this.line = line;
    }

    private void validate(List<Stick> line) {
        validateIsNotEmpty(line);
        validateIsNotOverlapped(line);
    }

    private void validateIsNotEmpty(List<Stick> line) {
        if (line.isEmpty()) {
            throw new IllegalArgumentException("적어도 가로 라인이 하나이상 있어야 한다.");
        }
    }

    private void validateIsNotOverlapped(List<Stick> line) {
        if (isRowLineOverlapped(line)) {
            throw new IllegalArgumentException("가로 라인이 이어지면 안된다.");
        }
    }

    private boolean isRowLineOverlapped(List<Stick> line) {
        return IntStream.range(1, line.size())
                .anyMatch(i -> line.get(i).isExist() && line.get(i - 1).isExist());
    }

    public boolean isExist(int position) {
        return line.get(position - 1).isExist();
    }
}
