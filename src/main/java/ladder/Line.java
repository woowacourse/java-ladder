package ladder;

import java.util.List;

public class Line {
    private final List<Position> positions;

    public Line(final List<Position> positions) {
        this.positions = positions;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Position position : positions) {
            stringBuilder.append("|");
            stringBuilder.append(position);
        }
        return stringBuilder.toString();
    }
}
