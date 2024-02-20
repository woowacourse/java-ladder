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
        if (height < 1 || height > 50) {
            throw new IllegalArgumentException("숫자는 1 이상 50 이하여야 합니다.");
        }
    }

    private boolean hasConnection(int threshold) {
        return threshold >= 5;
    }
}
