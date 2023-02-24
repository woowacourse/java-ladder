package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ladder.domain.ladder.ConnectionStatus;
import ladder.utils.BooleanGenerator;

public class Line {

    private final List<ConnectionStatus> points;
    private final Map<Integer, Integer> moveIndexPairs = new HashMap<>();

    public Line(final int width, final BooleanGenerator booleanGenerator) {
        this.points = new ArrayList<>();
        for (int position = 0; position < width; position++) {
            points.add(decideConnection(position, booleanGenerator));
        }
        initMoveIndexPairs();
    }

    private ConnectionStatus decideConnection(int position, BooleanGenerator booleanGenerator) {
        if (position == 0) {
            return ConnectionStatus.convertConnectionStatus(booleanGenerator.generate());
        }
        if (points.get(position - 1) == ConnectionStatus.CONNECTED) {
            return ConnectionStatus.DISCONNECTED;
        }
        return ConnectionStatus.convertConnectionStatus(booleanGenerator.generate());
    }

    private void initMoveIndexPairs() {
        for (int connectionIndex = 0; connectionIndex < points.size(); connectionIndex++) {
            if (points.get(connectionIndex) == ConnectionStatus.CONNECTED) {
                moveIndexPairs.put(connectionIndex, connectionIndex + 1);
                moveIndexPairs.put(connectionIndex + 1, connectionIndex);
            }
        }
    }

    public int indicateNextIndex(int startIndex) {
        int endIndex = startIndex;
        if (moveIndexPairs.containsKey(startIndex)) {
            endIndex = moveIndexPairs.get(startIndex);
        }
        return endIndex;
    }

    public List<ConnectionStatus> getLineStatus() {
        return List.copyOf(points);
    }
}
