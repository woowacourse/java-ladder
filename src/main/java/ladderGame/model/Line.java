package ladderGame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<DrawnStatus> isDrawns;

    public Line(int number) {
        isDrawns = new ArrayList<>();
        for (int i = 0; i < number - 1; i++) {
            drawSpace(i);
        }
    }

    private void drawSpace(int index) {
        if (index == 0 || !isDrawns.get(index - 1).checkDrawn()) {
            isDrawns.add(decideDrawnStatus());
            return;
        }
        isDrawns.add(DrawnStatus.NON_DRAWN);
    }

    private DrawnStatus decideDrawnStatus() {
        if (new Random().nextBoolean()) {
            return DrawnStatus.DRAWN;
        }
        return DrawnStatus.NON_DRAWN;
    }

    public List<DrawnStatus> getIsDrawns() {
        return new ArrayList<>(isDrawns);
    }

}
