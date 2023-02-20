package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import util.BridgeGenerator;

public class Ladder {
    private final List<Line> lines;

    public Ladder(Height height, int personCount) {
        this.lines = new ArrayList<>();
        for (int index = 0; index < height.getHeight(); index++) {
            lines.add(new Line(personCount));
        }
    }

    public void generate(BridgeGenerator bridgeGenerator) {
        for (Line line : lines) {
            line.generate(bridgeGenerator);
        }
    }

    public int calculateTotalHeight() {
        return lines.size();
    }

    public List<List<Bridge>> getStatus() {
        return lines.stream()
                .map(Line::getBridges)
                .collect(Collectors.toList());
    }
}
