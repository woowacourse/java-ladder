package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> line;

    public Line (List<Integer> numbers) {
        validateRange(numbers.size());
        List<Boolean> line = new ArrayList<>();
        line.add(false);
        for (int index = 1; index < numbers.size(); index++) {
            line.add(line.get(index - 1).equals(false)
                    && hasConnection(numbers.get(index)));
        }
        this.line = line;
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
