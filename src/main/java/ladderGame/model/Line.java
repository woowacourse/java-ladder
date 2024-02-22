package ladderGame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<DrawnStatus> spaces;

    public Line(int number) {
        spaces = new ArrayList<>();
        for (int i = 0; i < number - 1; i++) {
            drawSpace(i);
        }
    }

    private void drawSpace(int index) {
        if (index == 0 || !spaces.get(index - 1).equals(DrawnStatus.DRAWN)) {
            spaces.add(decideDrawnStatus());
            return;
        }
        spaces.add(DrawnStatus.NON_DRAWN);
    }

    private DrawnStatus decideDrawnStatus() {
        if (new Random().nextBoolean()) {
            return DrawnStatus.DRAWN;
        }
        return DrawnStatus.NON_DRAWN;
    }

    public List<DrawnStatus> getSpaces() {
        return new ArrayList<>(spaces);
    }

}
