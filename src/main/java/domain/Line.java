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

    private static final int THRESHOLD = 5;
    private static final int MIN_LINE = 2;
    private static final int MAX_LINE = 10;

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

    public List<Integer> getConnectedIndex() {
        return IntStream.range(0, line.size())
                .filter(value -> line.get(value).equals(CONNECTED))
                .boxed()
                .toList();
    }

    private void validateRange(int height) {
        if (height < MIN_LINE || height > MAX_LINE) {
            throw new IllegalArgumentException(String.format("숫자는 %d 이상 %d 이하여야 합니다.", MIN_LINE, MAX_LINE));
        }
    }

    private boolean hasConnection(int threshold) {
        return (threshold >= THRESHOLD);
    }

    public List<Connection> getLine() {
        return Collections.unmodifiableList(line);
    }
}
