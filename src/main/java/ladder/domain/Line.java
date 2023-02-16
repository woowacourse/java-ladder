package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<ConnectionStatus> points;

    public Line(final int width, final BooleanGenerator booleanGenerator) {
        this.points = new ArrayList<>();
        for (int position = 0; position < width; position++) {
            points.add(decideConnection(position, booleanGenerator));
        }
    }

    private ConnectionStatus decideConnection(int position, BooleanGenerator booleanGenerator) {
        if (position == 0) {
            return ConnectionStatus.convertConnectionStatus(booleanGenerator.generate());
        }
        if (points.get(position - 1) == ConnectionStatus.CONNECTED) {
            return ConnectionStatus.UNCONNECTED;
        }
        return ConnectionStatus.convertConnectionStatus(booleanGenerator.generate());
    }

    public List<ConnectionStatus> getLineStatus() {
        return List.copyOf(points);
    }
}
