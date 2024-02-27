package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static ladder.constant.ErrorMessage.CONTINUE_SCAFFOLD;

public class Line {
    private final List<Connection> connections;

    public Line(List<Connection> connections) {
        this.connections = new ArrayList<>(connections);
        validateContinue(this.connections);
    }

    private void validateContinue(List<Connection> connections) {
        if (isContinue(connections)) {
            throw new IllegalArgumentException(CONTINUE_SCAFFOLD.generate());
        }
    }

    private boolean isContinue(List<Connection> connections) {
        return IntStream.range(0, connections.size() - 1)
                .anyMatch(order -> isRung(order) && isRung(order + 1));
    }

    private boolean isRung(int order) {
        return Connection.RUNG.equals(connections.get(order));
    }

    public List<Connection> getConnections() {
        return List.copyOf(connections);
    }
}
