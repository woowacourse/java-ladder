package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Line implements Iterable<Boolean>{
    private final List<Boolean> line;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line1 = (Line) o;
        return Objects.equals(line, line1.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }

    @Override
    public Iterator<Boolean> iterator() {
        return line.iterator();
    }

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

    private void validateRange(int height) {
        if (height < 2 || height > 10) {
            throw new IllegalArgumentException("숫자는 2 이상 10 이하여야 합니다.");
        }
    }

    private boolean hasConnection(int threshold) {
        return threshold >= 5;
    }
}
