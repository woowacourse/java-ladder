package domain;

import java.util.Collections;
import util.Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static util.Connection.UNCONNECTED;

public class Line{
    private final List<Connection> line;

    public Line (List<Integer> numbers) {
        validateRange(numbers.size());
        List<Connection> line = new ArrayList<>();
        line.add(UNCONNECTED);
        for (int index = 1; index < numbers.size(); index++) {
            line.add(Connection.valueOfBridge(
                    line.get(index - 1).equals(UNCONNECTED)
                    && hasConnection(numbers.get(index))
            ));
        }
        this.line = line;
    }

    private void validateRange(int height) {
        if (height < 2 || height > 10) {
            throw new IllegalArgumentException("숫자는 2 이상 10 이하여야 합니다.");
        }
    }

    private boolean hasConnection(int threshold) {
        return (threshold >= 5);
    }

    public List<Connection> getConnections() {
        return Collections.unmodifiableList(this.line);
    }

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
}
