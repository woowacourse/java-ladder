package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> floors = new ArrayList<>();

    public Ladder(Floor floor, int playerNumber) {
        for (int i = 0; i < floor.getNumber(); i++) {
            floors.add(new Line(playerNumber));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Line line : this.floors) {
            sb.append(line.toString());
        }
        return sb.toString();
    }
}
