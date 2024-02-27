package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private static final int MIN_CONNECTION_COUNT = 1;

    private final List<Connection> connections;

    public Line(List<Connection> connections) {
        List<Connection> copy = new ArrayList<>(connections);
        validate(copy);
        this.connections = copy;
    }

    private void validate(List<Connection> connections) {
        validateMinConnectionCount(connections);
        validateConnectionContinuous(connections);
    }

    private void validateMinConnectionCount(List<Connection> connections) {
        if (connections.size() < MIN_CONNECTION_COUNT) {
            throw new IllegalArgumentException("라인은 1개 이상의 연결로 이루어져야 합니다.");
        }
    }

    private void validateConnectionContinuous(List<Connection> connections) {
        if (isContinuous(connections)) {
            throw new IllegalArgumentException("좌우 연속해서 발판이 존재할 수 없습니다.");
        }
    }

    private boolean isContinuous(List<Connection> connections) {
        return IntStream.range(0, connections.size() - 1)
                .anyMatch(order -> isRung(connections, order) && isRung(connections, order + 1));
    }

    private boolean isRung(List<Connection> connections, int order) {
        return Connection.RUNG.equals(connections.get(order));
    }

    public List<Connection> getConnections() {
        return List.copyOf(connections);
    }
}
