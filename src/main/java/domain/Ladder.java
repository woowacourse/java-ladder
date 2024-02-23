package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class Ladder {

    private final List<HorizontalLine> lines = new ArrayList<>();

    private Ladder(Players players, LadderHeight height) {
        createLadder(players, height);
    }

    public static Ladder of(Players players, LadderHeight height) {
        return new Ladder(players, height);
    }

    public void drawLines(BooleanSupplier supplier) {
        lines.forEach(line -> line.createPattern(supplier));
    }

    public List<HorizontalLinePattern> createStatuses() {
        return lines.stream()
                .map(HorizontalLine::createStatus)
                .toList();
    }

    private void createLadder(Players players, LadderHeight height) {
        int currentFloor = 0;
        while (!height.hasLengthOf(currentFloor)) {
            HorizontalLine line = new HorizontalLine(players.size());
            lines.add(line);
            currentFloor++;
        }
    }
}
