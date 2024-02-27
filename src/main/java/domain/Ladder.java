package domain;

import domain.booleangenerator.BooleanGenerator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int playerCount, Height height, BooleanGenerator booleanGenerator) {
        while (height.isRemain()) {
            lines.add(new Line(playerCount, booleanGenerator));
            height.decrease();
        }
    }

    public Map<Integer, List<Boolean>> getLinesInformation() {
        Map<Integer, List<Boolean>> information = new LinkedHashMap<>();
        for (int i = 0; i < lines.size(); i++) {
            information.put(i + 1, lines.get(i).getBridgesInformation());
        }
        return information;
    }

    public int getDestinationIndex(int start) {
        int position = start;
        for (Line line : lines) {
            position = line.getNextPosition(position);
        }
        return position;
    }
}
