package ladder;

import java.util.List;

public class Line {

    private final List<Boolean> connections;

    public Line(Boolean... connections) {
        validateConnections(connections);
        this.connections = List.of(connections);
    }

    private void validateConnections(Boolean[] connections) {
        for (int i = 1; i < connections.length; i++) {
            if (connections[i] && connections[i-1]) {
                throw new IllegalArgumentException("양 쪽으로 연결될 수 없습니다.");
            }
        }
    }

    public int move(int index) {
        if (connections.get(index)) {
            return index + 1;
        }
        if (index > 0 && connections.get(index - 1)) {
            return index - 1;
        }
        return index;
    }
}
