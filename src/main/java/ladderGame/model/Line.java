package ladderGame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<DrawnStatus> drawnStatuses;

    public Line(int number) {
        drawnStatuses = new ArrayList<>();
        for (int i = 0; i < number - 1; i++) {
            makeLine(i);
        }
    }

    private void makeLine(int index) {
        if (index == 0 || !drawnStatuses.get(index - 1).equals(DrawnStatus.DRAWN)) {
            drawnStatuses.add(decideDrawnStatus());
            return;
        }
        drawnStatuses.add(DrawnStatus.NON_DRAWN);
    }

    private DrawnStatus decideDrawnStatus() {
        if (new Random().nextBoolean()) {
            return DrawnStatus.DRAWN;
        }
        return DrawnStatus.NON_DRAWN;
    }

    public List<DrawnStatus> getDrawnStatuses() {
        return new ArrayList<>(drawnStatuses);
    }

}
