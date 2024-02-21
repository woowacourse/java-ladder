package domain;

import java.util.List;

public class Line {
    private final List<Boolean> line;

    public Line (List<Integer> numbers) {
        validateRange(numbers.size());
        this.line = numbers.stream()
                .map(this::hasConnection)
                .toList();
    }

    public boolean getValue(int index) {
        return line.get(index);
    }

    private void validateRange(int height) {
        if (height < 2 || height > 10) {
            throw new IllegalArgumentException("숫자는 2 이상 10 이하여야 합니다.");
        }
    }

    private boolean hasConnection(int threshold) {
        return threshold >= 5;
    }
}
