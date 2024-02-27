package domain;

import static util.Connection.CONNECTED;
import static util.Connection.UNCONNECTED;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import util.Connection;

public class Line {
    private final List<Connection> line;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Line line1 = (Line) obj;
        return Objects.equals(line, line1.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }

    public Line (List<Integer> numbers) {
        validateRange(numbers.size());
        List<Connection> line = new ArrayList<>();
        line.add(UNCONNECTED);
        buildLine(numbers, line);
        this.line = line;
    }

    private void buildLine(List<Integer> numbers, List<Connection> line) {
        for (int index = 1; index < numbers.size(); index++) {
            line.add(Connection.valueOfBridge(
                    line.get(index - 1).equals(UNCONNECTED)
                    && hasConnection(numbers.get(index))
            ));
        }
    }

    public List<Integer> getUnconnectedIndex() {
        return IntStream.range(0, line.size())
                .filter(value -> line.get(value).equals(CONNECTED))
                .boxed()
                .toList();
    }

    private void validateRange(int height) {
        if (height < 2 || height > 10) {
            throw new IllegalArgumentException("숫자는 2 이상 10 이하여야 합니다.");
        }
    }

    private boolean hasConnection(int threshold) {
        return (threshold >= 5);
    }

    public List<Connection> getLine() {
        return Collections.unmodifiableList(line);
    }
}
